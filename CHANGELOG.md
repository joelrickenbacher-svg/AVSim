# Changelog

Alle nennenswerten Änderungen an AVSim. Neueste Version oben. Dieselbe Liste steht in der App unter „Changelog“.

## v3.3 – 2026-11-19
- Sichtreferenz wählbar: CAT I (1 Licht) oder LTS CAT I / CAT II / III (3 Lichter).
- CMV-Rechner: RVR aus VIS nach EASA AMC10 CAT.OP.MPA.110, mit Übernahme-Taste.
- „Grundlagen & Quellen“ in der App und `docs/QUELLEN.md`: belegte Werte, Herleitungen, Schätzungen.
- Changelog in der App und im Repo.
- Android: Quellen-Links öffnen im externen Browser.
- CI: Release-Workflow baut APK, HTML und ZIP bei Tags `v*`.

## v3.2 – 2026-11-19
- ±-Taste für negative Temperatur und Taupunkt (die Handy-Zifferntastatur hat kein Minus).
- Warnung, wenn der Taupunkt über der Temperatur liegt.
- Feinschliff: Temperatur/Taupunkt untereinander, Eingabefelder 16 px auf dem Handy, kompaktere Live-Zeile.

## v3.1 – 2026-11-19
- Minima werden gegen die gemeldeten VIS/RVR geprüft, nicht gegen reduzierte Werte.
- Schalter „Wetter ist bereits in VIS/RVR enthalten“ gegen Doppelzählung.
- TCH (Standard 50 ft): der Gleitpfad kreuzt die Schwelle in dieser Höhe.
- Sichtquelle Auto: ALS und Schwelle nach RVR, Piste nach Minimum aus VIS und RVR.
- Höhe heißt jetzt THRE (Schwellenhöhe).

## v3.0 – 2026-11-19
- Komplett neu aufgebaut: Live-Berechnung, Szenario-Chips, Schieberegler, Tabs auf dem Handy.
- Anflugprofil zoom- und verschiebbar (Pinch, Doppeltippen, Buttons), ohne die App zu zoomen.
- Tag/Nacht wechselt die ganze Oberfläche (nur Darstellung), Eingaben werden gespeichert.
- Ergebnis kopieren, Zurücksetzen mit Rückgängig.
- Android-Projekt (WebView) mit AndroidX-Fix, Systemleisten passend zum Theme, adaptivem Icon.

## Frühere Versionen
- Max. Distanz 6 NM, Niederschlag SHRA, Tag/Nacht-Schalter, neues Layout und überarbeitete Grafik.
- Ausgangspunkt: HTML-Modell mit ALS-, Schwellen- und Pistensichtbarkeit entlang des Gleitpfads.
