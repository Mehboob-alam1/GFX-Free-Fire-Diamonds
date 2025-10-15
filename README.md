# GFX Game Launcher - Diamond Edition

<div align="center">
  <img src="app/src/main/res/mipmap-xxxhdpi/ic_launcher.png" alt="App Icon" width="120" height="120">
  
  **Un'applicazione completa per la gestione dei giochi e il guadagno di diamanti Free Fire**
  
  [![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)](https://www.android.com/)
  [![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)](https://www.java.com/)
  [![Firebase](https://img.shields.io/badge/Firebase-FFCA28?style=for-the-badge&logo=firebase&logoColor=black)](https://firebase.google.com/)
  [![License](https://img.shields.io/badge/License-MIT-green?style=for-the-badge)](LICENSE)
</div>

---

## 📱 Panoramica

GFX Game Launcher è un'applicazione Android completa che combina strumenti GFX avanzati per i giochi con una sezione dedicata per guadagnare diamanti Free Fire. L'app offre funzionalità di ottimizzazione delle performance, gestione delle risorse e guide complete per i diamanti.

### ✨ Caratteristiche Principali

- 🎮 **Strumenti GFX Avanzati** - Ottimizzazione performance e gestione risorse
- 💎 **Guadagno Diamanti Free Fire** - Guide complete e calcolatori
- 📊 **Analytics in Tempo Reale** - Monitoraggio performance e utilizzo
- 🎯 **Sistema Annunci Integrato** - Gestione dinamica tramite Firebase
- 🔄 **Onboarding Interattivo** - Esperienza utente guidata
- 📱 **Design Moderno** - Interfaccia intuitiva e responsive

---

## 🚀 Funzionalità

### 🎮 Tab GFX Tool
- **Home Dashboard** - Panoramica sistema e performance
- **Analytics** - Statistiche dettagliate e monitoraggio
- **Settings** - Configurazioni avanzate e personalizzazioni
- **Game Management** - Aggiunta e gestione giochi
- **Clean Up** - Pulizia automatica e ottimizzazione

### 💎 Tab Get Diamonds
- **Diamond Guide** - Guide complete per guadagnare diamanti
- **Tips & Tricks** - Consigli e strategie avanzate
- **Sport Vehicles** - Informazioni sui veicoli sportivi
- **Different Weapons** - Guide sulle armi
- **Man Character** - Gestione personaggi
- **Rare Emotes** - Collezione emote rare
- **Diamond Calculator** - Calcolatore per diversi tipi di diamanti

### 🔧 Sistema Avanzato
- **Firebase Integration** - Configurazione remota e analytics
- **Dynamic Ad System** - Annunci WebView personalizzabili
- **Survey System** - Sistema di feedback utente
- **Onboarding Flow** - Guida interattiva per nuovi utenti

---

## 📸 Screenshots

<div align="center">
  
### Splash Screen & Onboarding
<img src="screenshots/splash.png" alt="Splash Screen" width="200">
<img src="screenshots/onboarding1.png" alt="Onboarding 1" width="200">
<img src="screenshots/onboarding2.png" alt="Onboarding 2" width="200">

### Main Interface
<img src="screenshots/main_tabs.png" alt="Main Tabs" width="200">
<img src="screenshots/gfx_home.png" alt="GFX Home" width="200">
<img src="screenshots/gfx_analytics.png" alt="GFX Analytics" width="200">

### Diamond Section
<img src="screenshots/diamond_main.png" alt="Diamond Main" width="200">
<img src="screenshots/diamond_guide.png" alt="Diamond Guide" width="200">
<img src="screenshots/diamond_calculator.png" alt="Diamond Calculator" width="200">

### Ad System
<img src="screenshots/ad_webview.png" alt="Ad WebView" width="200">
<img src="screenshots/survey.png" alt="Survey" width="200">

</div>

---

## 🛠️ Tecnologie Utilizzate

### Core Technologies
- **Android SDK** - Framework principale
- **Java** - Linguaggio di programmazione
- **Firebase** - Backend e analytics
- **WebView** - Sistema annunci integrato

### Libraries & Dependencies
```gradle
// Firebase
implementation platform('com.google.firebase:firebase-bom:32.7.0')
implementation 'com.google.firebase:firebase-database'
implementation 'com.google.firebase:firebase-analytics'

// AndroidX
implementation 'androidx.appcompat:appcompat:1.6.1'
implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
implementation 'androidx.viewpager2:viewpager2:1.0.0'
implementation 'com.google.android.material:material:1.9.0'

// UI Components
implementation 'androidx.fragment:fragment:1.6.1'
implementation 'androidx.navigation:navigation-fragment:2.6.0'
```

---

## 📋 Requisiti di Sistema

- **Android Version:** 6.0 (API level 23) o superiore
- **RAM:** Minimo 2GB, Consigliato 4GB+
- **Storage:** 50MB di spazio libero
- **Permissions:** Storage, Internet, Network State

---

## 🔧 Installazione

### Prerequisiti
1. Android Studio (ultima versione)
2. Android SDK (API level 23+)
3. Firebase Project configurato
4. Java Development Kit (JDK 8+)

### Setup
1. **Clona il repository:**
   ```bash
   git clone https://github.com/Mehboob-alam1/gfx-game-launcher.git
   cd gfx-game-launcher
   ```

2. **Configura Firebase:**
   - Crea un progetto Firebase
   - Aggiungi `google-services.json` in `app/`
   - Configura Realtime Database

3. **Build e Run:**
   ```bash
   ./gradlew assembleDebug
   ```

4. **Installa l'APK:**
   ```bash
   adb install app/build/outputs/apk/debug/app-debug.apk
   ```

---

## ⚙️ Configurazione Firebase

### Database Structure
```json
{
  "adUrl": "https://easyranktools.com",
  "showAds": true,
  "showSurvey": true
}
```

### Configurazione Remota
- **`adUrl`** - URL per gli annunci WebView
- **`showAds`** - Abilita/disabilita sistema annunci
- **`showSurvey`** - Abilita/disabilita sistema survey

---

## 📱 Architettura dell'App

```
app/
├── src/main/
│   ├── java/com/elevenappstudio/getdailydiamondguide/
│   │   ├── SplashActivity.java              # Schermata iniziale
│   │   ├── OnboardingActivity.java          # Onboarding flow
│   │   ├── MainTabsActivity.java            # Main container
│   │   ├── AdWebViewActivity.java           # Sistema annunci
│   │   ├── FirebaseUrlManager.java          # Gestione Firebase
│   │   ├── Fragments/                       # Fragment GFX
│   │   ├── Bottomsheets/                    # Bottom sheets
│   │   └── DiamondApp/                      # App Diamond integrata
│   ├── res/
│   │   ├── layout/                          # Layout XML
│   │   ├── drawable/                        # Risorse grafiche
│   │   ├── values/                          # Colori, stili, stringhe
│   │   └── anim/                            # Animazioni
│   └── AndroidManifest.xml                  # Manifesto app
```

---

## 🎯 Flusso Utente

### 1. Avvio App
- Splash screen (3 secondi)
- Controllo configurazione Firebase
- Decisione: Onboarding o Main App

### 2. Onboarding (se abilitato)
- 5 schermate interattive
- Annunci WebView su ogni schermata
- Navigazione solo tramite pulsanti

### 3. Survey System (se abilitato)
- 5 schermate di survey
- Annunci WebView dopo ogni risposta
- Timer 15 secondi per annunci

### 4. Main Application
- **Tab "Get Diamonds"** - App Diamond integrata
- **Tab "GFX Tool"** - Strumenti GFX originali

---

## 🔐 Sistema Annunci

### Caratteristiche
- **WebView integrato** - Annunci all'interno dell'app
- **Timer 15 secondi** - Non chiudibile prima del tempo
- **URL nascosto** - L'utente non vede l'URL
- **Controllo Firebase** - Abilitazione/disabilitazione remota

### Implementazione
```java
// Controllo annunci
if (FirebaseUrlManager.getInstance().shouldShowAds()) {
    showAdThenNavigate(targetActivity);
} else {
    navigateDirectly(targetActivity);
}
```

---

## 📊 Analytics e Monitoring

### Firebase Analytics
- Eventi utente personalizzati
- Tracking navigazione
- Performance monitoring
- Crash reporting

### Metriche Tracciate
- Sessioni utente
- Tempo di utilizzo
- Pulsanti cliccati
- Errori e crash

---

## 🚀 Roadmap Futura

### Versione 2.0
- [ ] Sistema di notifiche push
- [ ] Backup cloud delle configurazioni
- [ ] Temi personalizzabili
- [ ] Supporto per più giochi

### Versione 2.1
- [ ] Sistema di achievement
- [ ] Community features
- [ ] API integration
- [ ] Widget home screen

---

## 🤝 Contribuire

Siamo aperti ai contributi! Ecco come puoi aiutare:

1. **Fork** il repository
2. **Crea** un branch per la tua feature (`git checkout -b feature/AmazingFeature`)
3. **Commit** le tue modifiche (`git commit -m 'Add some AmazingFeature'`)
4. **Push** al branch (`git push origin feature/AmazingFeature`)
5. **Apri** una Pull Request

### Linee Guida
- Segui le convenzioni di codice Java
- Aggiungi commenti per codice complesso
- Testa le tue modifiche
- Aggiorna la documentazione

---

## 📄 Licenza

Questo progetto è sotto licenza MIT. Vedi il file [LICENSE](LICENSE) per maggiori dettagli.

---

## 👨‍💻 Autore

**Mehboob Alam**
- GitHub: [@Mehboob-alam1](https://github.com/Mehboob-alam1)
- Email: mehboobcodes@gmail.com

---

## 🙏 Ringraziamenti

- **Free Fire Community** - Per il feedback e i suggerimenti
- **Firebase Team** - Per l'ecosistema di sviluppo
- **Android Community** - Per le risorse e il supporto
- **Twelve Studios** - Per il progetto originale

---

## 📞 Supporto

Per supporto e domande:
- 📧 **Email:** mehboobcodes@gmail.com
- 🐛 **Bug Reports:** [Issues](https://github.com/Mehboob-alam1/gfx-game-launcher/issues)
- 💬 **Discussions:** [GitHub Discussions](https://github.com/Mehboob-alam1/gfx-game-launcher/discussions)

---

<div align="center">
  <p><strong>⭐ Se questo progetto ti è utile, lascia una stella!</strong></p>
  
  <p>
    <a href="#top">⬆️ Torna in cima</a>
  </p>
</div>
