package com.avsim.app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.webkit.WebViewAssetLoader;

/**
 * AVSim – Approach Visual Acquisition Simulator.
 * Einfache WebView-App: die komplette Logik liegt in assets/index.html (offline).
 * Seiten-Zoom ist deaktiviert – gezoomt wird nur das Approach-Profil (in der Seite selbst).
 */
public class MainActivity extends AppCompatActivity {

    private static final int NIGHT_BAR = 0xFF0D1621;
    private static final int DAY_BAR = 0xFFFFFFFF;

    private WebView webView;

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        applyBars(true);

        webView = findViewById(R.id.webView);
        webView.setBackgroundColor(0xFF060B12);

        WebSettings s = webView.getSettings();
        s.setJavaScriptEnabled(true);
        s.setDomStorageEnabled(true);          // localStorage: Eingaben + Theme werden gemerkt
        s.setSupportZoom(false);               // kein Zoom der ganzen Oberfläche
        s.setBuiltInZoomControls(false);
        s.setDisplayZoomControls(false);
        s.setAllowFileAccess(false);
        s.setAllowContentAccess(false);
        s.setTextZoom(100);

        // Assets über eine sichere https-Origin ausliefern (stabiler localStorage, Clipboard-API)
        final WebViewAssetLoader loader = new WebViewAssetLoader.Builder()
                .addPathHandler("/assets/", new WebViewAssetLoader.AssetsPathHandler(this))
                .build();
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                Uri u = request.getUrl();
                if ("appassets.androidplatform.net".equals(u.getHost())) return false;
                try { startActivity(new Intent(Intent.ACTION_VIEW, u)); } catch (Exception ignored) { }
                return true; // Quellen-Links im externen Browser öffnen, App bleibt stehen
            }

            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
                return loader.shouldInterceptRequest(request.getUrl());
            }
        });

        // Brücke: die Seite meldet Tag/Nacht, damit Status- und Navigationsleiste passen
        webView.addJavascriptInterface(new Object() {
            @JavascriptInterface
            public void setTheme(final String mode) {
                runOnUiThread(() -> applyBars("night".equals(mode)));
            }
        }, "AVSimNative");

        webView.loadUrl("https://appassets.androidplatform.net/assets/index.html");
    }

    private void applyBars(boolean night) {
        int color = night ? NIGHT_BAR : DAY_BAR;
        getWindow().setStatusBarColor(color);
        getWindow().setNavigationBarColor(color);
        WindowInsetsControllerCompat c =
                new WindowInsetsControllerCompat(getWindow(), getWindow().getDecorView());
        c.setAppearanceLightStatusBars(!night);
        c.setAppearanceLightNavigationBars(!night);
    }

    @Override
    protected void onPause() {
        if (webView != null) webView.onPause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (webView != null) webView.onResume();
    }

    @Override
    protected void onDestroy() {
        if (webView != null) {
            webView.removeJavascriptInterface("AVSimNative");
            webView.destroy();
        }
        super.onDestroy();
    }
}
