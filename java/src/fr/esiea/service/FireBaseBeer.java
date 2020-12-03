package fr.esiea.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class FireBaseBeer {
  public static String getBeer(String id) throws ExecutionException, InterruptedException {
    Firestore dbFireStore = FirestoreClient.getFirestore();
    DocumentReference documentReference = dbFireStore.collection("beers").document(id);
    ApiFuture<DocumentSnapshot> future = documentReference.get();
    DocumentSnapshot document = future.get();

    if(document.exists()) {
      return  document.getId();
    } else {
      return null;
    }
  }
}
