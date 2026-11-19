# AVSim – Approach Visual Acquisition Simulator (v3.4)

Heuristisches Trainingsmodell: Ab welcher Distanz werden ALS, Schwelle (THR) und Piste (RWY)
im Anflug sichtbar – abhängig von VIS/RVR, Wetter, Ceiling, Befeuerung und Minima (DA/DH).
**Nicht für den operationellen Einsatz.**

## In Android Studio öffnen

1. ZIP entpacken
2. Android Studio → *Open* → Ordner `AVSim` wählen
3. Gradle-Sync abwarten (Android Studio Hedgehog oder neuer, JDK 17 ist eingebaut)
4. Gerät oder Emulator wählen → ▶ Run

Voraussetzungen: Android 8.0+ (API 26), Android SDK 34.
Falls der Gradle-Wrapper fehlt: *Terminal* → `gradle wrapper --gradle-version 8.2`.

## Aufbau

- Eine Activity mit WebView, die `app/src/main/assets/index.html` lädt – komplett offline.
- Seiten-Zoom ist deaktiviert. Gezoomt wird nur das Approach-Profil
  (Pinch, Doppeltippen, Buttons +/−, Gesamtansicht, Endanflug).
- Eingaben und Tag/Nacht-Einstellung werden lokal gespeichert.
- Status- und Navigationsleiste folgen dem Tag/Nacht-Schalter (Brücke `AVSimNative`).

## Simulator aktualisieren

`app/src/main/assets/index.html` ersetzen und neu bauen. Dieselbe Datei läuft auch direkt im Browser.

## Änderungen v3.1 (Modell)

- Minima (VIS/RVR) werden gegen die **gemeldeten** Werte geprüft, nicht gegen die reduzierten.
- Schalter „Wetter ist bereits in VIS/RVR enthalten“ (keine Doppelzählung durch Niederschlag/Nebel/Taupunkt).
- TCH (Standard 50 ft): der Gleitpfad kreuzt die Schwelle in TCH-Höhe.
- Sichtquelle Auto: ALS und Schwelle (Lichter) nach RVR, Piste nach min(VIS, RVR).
- ALS gilt als sichtbar, sobald das 3. Licht (60 m nach dem Außenende) sichtbar ist.
- Höhe heißt jetzt THRE (Schwellenhöhe). Die Faktoren sind Schätzwerte und nicht kalibriert.

## Änderungen v3.2

- Temperatur/Taupunkt: ±-Taste für negative Werte (die Zifferntastatur am Handy hat kein Minus); Warnung, wenn der Taupunkt über der Temperatur liegt.
- Temp/Taupunkt-Felder untereinander statt nebeneinander, Eingabefelder auf dem Handy 16 px.
- Kompaktere Live-Zeile auf schmalen Bildschirmen.

## Änderungen v3.3 (Recherche)

- **Sichtreferenz** wählbar: CAT I = 1 Licht (Standard), LTS CAT I / CAT II / III = 3 aufeinanderfolgende Lichter (EASA AMC1 CAT.OP.MPA.305(e)). In v3.1/v3.2 galt fest die 3-Lichter-Regel.
- **CMV-Rechner** (Erweitert): RVR aus VIS nach EASA AMC10 CAT.OP.MPA.110 (HI-Feuer 1.5 Tag / 2.0 Nacht, andere 1.0 / 1.5, ohne 1.0), mit Übernahme-Taste.
- **Grundlagen & Quellen** in der App: welche Werte belegt sind (Regen, Pistenkontrast, Lichtintensität) und welche Schätzung bleiben (Nebel, Taupunkt). Siehe auch `docs/QUELLEN.md`.
- Quellen-Links öffnen im externen Browser.

Änderungsverlauf: siehe `CHANGELOG.md` (auch in der App unter „Changelog“).
