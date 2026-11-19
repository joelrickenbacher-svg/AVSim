# AVSim – Approach Visual Acquisition Simulator (v3)

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
