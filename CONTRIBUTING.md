# Contributing to GFX Game Launcher

Grazie per il tuo interesse a contribuire a GFX Game Launcher! Questo documento fornisce le linee guida per contribuire al progetto.

## 🚀 Come Contribuire

### 1. Fork del Repository
1. Vai su [GitHub](https://github.com/Mehboob-alam1/gfx-game-launcher)
2. Clicca su "Fork" nell'angolo in alto a destra
3. Clona il tuo fork localmente:
   ```bash
   git clone https://github.com/YOUR_USERNAME/gfx-game-launcher.git
   cd gfx-game-launcher
   ```

### 2. Setup Ambiente di Sviluppo

#### Prerequisiti
- **Android Studio** (ultima versione)
- **Android SDK** (API level 23+)
- **Java Development Kit** (JDK 8+)
- **Firebase Project** configurato

#### Configurazione
1. **Apri il progetto** in Android Studio
2. **Configura Firebase:**
   - Crea un progetto Firebase
   - Aggiungi `google-services.json` in `app/`
   - Configura Realtime Database
3. **Sync Gradle** e risolvi eventuali dipendenze
4. **Testa l'app** su dispositivo/emulatore

### 3. Creare un Branch
```bash
git checkout -b feature/your-feature-name
# oppure
git checkout -b bugfix/issue-description
```

### 4. Sviluppo
- **Segui le convenzioni** di codice Java
- **Aggiungi commenti** per codice complesso
- **Testa le tue modifiche** prima del commit
- **Aggiorna la documentazione** se necessario

### 5. Commit e Push
```bash
git add .
git commit -m "Add: Descrizione della modifica"
git push origin feature/your-feature-name
```

### 6. Pull Request
1. Vai su GitHub e clicca "New Pull Request"
2. **Descrivi le modifiche** in dettaglio
3. **Collega eventuali issues** correlate
4. **Aggiungi screenshot** se necessario

## 📋 Linee Guida per il Codice

### Convenzioni Java
```java
// ✅ Buono
public class MyActivity extends AppCompatActivity {
    private static final String TAG = "MyActivity";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Codice qui
    }
}

// ❌ Evitare
public class myactivity extends appcompatactivity{
    protected void oncreate(bundle savedinstancestate){
        // Codice senza convenzioni
    }
}
```

### Struttura File
```
app/src/main/java/com/elevenappstudio/getdailydiamondguide/
├── Activities/           # Activity principali
├── Fragments/           # Fragment dell'app
├── Adapters/            # Adapter per RecyclerView
├── Models/              # Modelli dati
├── Utils/               # Utility e helper
├── DiamondApp/          # App Diamond integrata
└── Bottomsheets/        # Bottom sheet components
```

### Commenti
```java
/**
 * Mostra un annuncio WebView prima di navigare alla destinazione
 * @param targetActivity La classe activity di destinazione
 * @param extraName Nome extra da passare (opzionale)
 */
private void showAdThenNavigate(Class<?> targetActivity, String extraName) {
    // Implementazione
}
```

## 🐛 Bug Reports

### Come Segnalare un Bug
1. **Verifica** che non sia già stato segnalato
2. **Crea una nuova issue** con template bug report
3. **Includi:**
   - Descrizione dettagliata
   - Passi per riprodurre
   - Screenshot/video se necessario
   - Informazioni dispositivo/Android version

### Template Bug Report
```markdown
**Descrizione del Bug**
Descrizione chiara del problema.

**Passi per Riprodurre**
1. Vai a '...'
2. Clicca su '...'
3. Vedi errore

**Comportamento Atteso**
Cosa dovrebbe succedere.

**Screenshots**
Aggiungi screenshot se necessario.

**Informazioni Dispositivo:**
- Android Version: [es. 12]
- App Version: [es. 1.0.0]
- Device: [es. Samsung Galaxy S21]
```

## ✨ Feature Requests

### Come Richiedere una Feature
1. **Verifica** che non sia già stata richiesta
2. **Crea una nuova issue** con template feature request
3. **Descrivi** il valore aggiunto della feature
4. **Proponi** una soluzione se hai idee

### Template Feature Request
```markdown
**Feature Richiesta**
Descrizione chiara della feature.

**Problema che Risolve**
Quale problema risolverebbe questa feature.

**Soluzione Proposta**
Come implementeresti la feature.

**Alternative Considerate**
Altre soluzioni considerate.

**Informazioni Aggiuntive**
Screenshot, mockup, o altre informazioni.
```

## 🧪 Testing

### Test Locali
```bash
# Build debug
./gradlew assembleDebug

# Test unitari
./gradlew test

# Test UI
./gradlew connectedAndroidTest
```

### Checklist Pre-Commit
- [ ] Codice compila senza errori
- [ ] Test passano
- [ ] Codice segue le convenzioni
- [ ] Commenti aggiunti dove necessario
- [ ] Documentazione aggiornata

## 📚 Risorse

### Documentazione
- [Android Developer Guide](https://developer.android.com/guide)
- [Firebase Documentation](https://firebase.google.com/docs)
- [Material Design](https://material.io/design)

### Strumenti
- [Android Studio](https://developer.android.com/studio)
- [Firebase Console](https://console.firebase.google.com/)
- [GitHub Desktop](https://desktop.github.com/)

## 🤝 Comunità

### Comunicazione
- **Issues**: Per bug e feature requests
- **Discussions**: Per domande generali
- **Email**: mehboobcodes@gmail.com per questioni private

### Codice di Condotta
- **Rispetta** tutti i membri della comunità
- **Sii costruttivo** nei feedback
- **Aiuta** gli altri quando possibile
- **Mantieni** un ambiente positivo

## 📝 Licenza

Contribuendo a questo progetto, accetti che le tue modifiche saranno rilasciate sotto la licenza MIT.

## 🙏 Ringraziamenti

Grazie a tutti i contributori che rendono questo progetto possibile!

---

**Hai domande?** Contatta [Mehboob Alam](mailto:mehboobcodes@gmail.com) o apri una [discussion](https://github.com/Mehboob-alam1/gfx-game-launcher/discussions).
