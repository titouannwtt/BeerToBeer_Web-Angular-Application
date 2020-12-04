package fr.esiea.service;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firestore.v1.Document;
import fr.esiea.model.Beer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;

  @Service
  public class FirebaseServiceBeer {
    public String deleteBeer;

    public String saveBeerDetails(Beer beer) throws ExecutionException, InterruptedException {
      Firestore dbFirestore = FirestoreClient.getFirestore();
      ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("beers").document(beer.getName()).set(beer);
      return collectionsApiFuture.get().getUpdateTime().toString();

    }

    public List<Beer> getAllBeers() throws ExecutionException, InterruptedException {
      List<Beer> beerList = new ArrayList<Beer>();

      Firestore dbFireStore = FirestoreClient.getFirestore();

      ApiFuture<QuerySnapshot> future = dbFireStore.collection("beers").get();

      List<QueryDocumentSnapshot> documents = future.get().getDocuments();
      for (QueryDocumentSnapshot document : documents) {
        System.out.println(document.getId() + " => " + document.toObject(Beer.class));
        beerList.add(document.toObject(Beer.class));
      }

      return beerList;
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
