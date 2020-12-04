package fr.esiea;

import java.io.FileInputStream;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class FirebaseInitialize {

  @PostConstruct
  public void initialize() {
    try {
      FileInputStream ServiceAccount =
        new FileInputStream("./ServiceAccount.json");

      FirebaseOptions options = new FirebaseOptions.Builder()
        .setCredentials(GoogleCredentials.fromStream(ServiceAccount))
        .setDatabaseUrl("https://nuitinfo-4e97f-default-rtdb.firebaseio.com\"")
        .build();

      FirebaseApp.initializeApp(options);
    } catch (Exception e) {
      e.printStackTrace();

    }
  }
}