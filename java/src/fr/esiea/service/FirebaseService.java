package fr.esiea.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import fr.esiea.Beer;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

  @Service
  public class FirebaseService {
    public String deleteBeer;

    public String saveBeerDetails(Beer beer) throws ExecutionException, InterruptedException {
      Firestore dbFirestore = FirestoreClient.getFirestore();
      ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("beers").document(beer.getName()).set(beer);
      return collectionsApiFuture.get().getUpdateTime().toString();

    }
    public Beer getBeerDetails(String name) throws ExecutionException, InterruptedException {
      Firestore dbFireStore = FirestoreClient.getFirestore();
      DocumentReference documentReference = dbFireStore.collection("beers").document(name);
      ApiFuture<DocumentSnapshot> future = documentReference.get();

      DocumentSnapshot document = future.get();

      Beer beer = null;
      if (document.exists()) {
        beer = document.toObject(Beer.class);
        return beer;
      } else {
        return null;
      }
    }

    public String updateBeerDetails(Beer beer) throws ExecutionException, InterruptedException {
      Firestore dbFirestore = FirestoreClient.getFirestore();
      ApiFuture<WriteResult> collectionsApiFuture = (ApiFuture<WriteResult>) dbFirestore.collection("beers").document(String.valueOf(beer));
      return collectionsApiFuture.get().getUpdateTime().toString();
    }
  }
