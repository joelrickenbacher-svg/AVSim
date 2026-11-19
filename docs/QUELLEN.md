# AVSim – Grundlagen, Herleitungen, Quellen

Stand: v3.3. Heuristisches Trainingsmodell, nicht für den operationellen Einsatz.

## Belegt oder hergeleitet

| Modellwert | Herleitung | Quelle |
|---|---|---|
| Sichtreferenz 1 Licht (CAT I) bzw. 3 Lichter (LTS CAT I, CAT II, III) | Wortlaut der AMC | EASA AMC1 CAT.OP.MPA.305(e) |
| CMV-Faktoren HI 1.5/2.0, andere 1.0/1.5, keine 1.0/– | Tabelle der AMC; nicht für RVR-Minima < 800 m und nicht für Take-off | EASA AMC10 CAT.OP.MPA.110 |
| Pistenfaktoren 0.72 / 0.80 / 0.88 | Koschmieder, ε = 0.05: x = MOR·ln(C₀/0.05)/ln 20 → C₀ ≈ 0.43 / 0.55 / 0.70 | WMO CIMO Guide, Kap. 9 |
| ALS-Helligkeit 1.15 / 1.00 / 0.90 | Allard: Δln x/Δln I = 1/(2+σx) ≈ 0.2 bei x ≈ MOR → 2× Intensität ≈ ×1.15, ½× ≈ ×0.87 | WMO CIMO Guide, Kap. 9 |
| Regen 0.92 / 0.78 / 0.62 (leicht/mäßig/stark) | Reine Regen-MOR ≈ 16 / 5.4 / 2.6 km bei 1 / 5 / 15 mm/h (Mittel zweier Fits, MOR = 19.5·R^-0.77 und 13.0·R^-0.58 km); Extinktionen addieren sich → bei VIS 1500 m ×0.92 / 0.78 / 0.63 | Montero-Martínez & García-García (2025), Atmósfera 39 |

Die Regenfaktoren stimmen nur nahe VIS 1500 m. Bei höherer VIS wirkt Regen relativ stärker, bei niedrigerer schwächer.

## Schnee

Reine Schnee-Sicht ≈ 1.01·PR^-0.70 km (Gultepe, Milbrandt & Zhou 2010; Koeffizienten aus einem teils schlecht lesbaren Extrakt, ungefähr). Bei 0.5 / 1.75 / 4 mm/h sind das ≈ 1.6 / 0.7 / 0.4 km. Das ist deutlich stärker als die App-Faktoren 0.88 / 0.68 / 0.48. Diese verstehen sich als Zusatzreduktion über die gemeldete VIS hinaus.

## Schätzung ohne Quelle

- Nebel/Dunst/BCFG-Faktoren (VIS und RVR) und die Taupunkt-Stufen: keine veröffentlichte Umrechnung gefunden.
- Detektionsfaktoren für Schwelle (0.95).
- Gemeldete VIS/RVR enthalten Niederschlag und Nebel bereits. Die Zusatzfaktoren sind ein Modellansatz für die schlechtere Schrägsicht. Schalter „Wetter ist bereits in VIS/RVR enthalten“ schaltet sie ab.
- Nicht modelliert: Wind, Querversatz, Scheibenregen, Blendung, Landescheinwerfer, Wolkenschichten.

## Quellen

- EASA Easy Access Rules Air Operations: https://www.easa.europa.eu/en/downloads/136713/en
- SKYbrary Visual References: https://skybrary.aero/articles/visual-references
- WMO CIMO Guide Kap. 9: https://old.wmo.int/extranet/pages/prog/www/IMOP/publications/CIMO-Guide/Prelim_2018_ed/8_I_9_en_MR_tc.pdf
- Montero-Martínez & García-García 2025: https://www.scielo.org.mx/pdf/atm/v39/0187-6236-atm-39-53491.pdf
- Gultepe, Milbrandt & Zhou 2010: https://meetingorganizer.copernicus.org/FOGDEW2010/FOGDEW2010-112-1.pdf

## Kalibrierung (v3.5)

Beobachtete Erstsicht-Distanz d → Faktor k = Schrägdistanz(d) / (Sichtweite × Detektionsfaktor). Die App nimmt den Median von k je Referenz. Das ist eine Schätzung aus wenigen Einzelbeobachtungen: Sichtangaben sind subjektiv (Streuung der Beobachter laut WMO etwa 15 bis 30 %), und die Wetterlage entspricht den Eingaben zum Zeitpunkt des Speicherns.
