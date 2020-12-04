package fr.esiea.restservice;

import fr.esiea.model.Beer;
import fr.esiea.service.FirebaseServiceBeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@org.springframework.web.bind.annotation.RestController


public class RestBeer {

  @Autowired
  FirebaseServiceBeer firebaseServiceBeer;

  @GetMapping("/getBeerDetails")
  public Beer getExample(@RequestHeader() String name ) throws InterruptedException, ExecutionException {
    return firebaseServiceBeer.getBeerDetails(name);
  }
  @PostMapping("/createBeer")
  public String postExample(@RequestBody Beer beer) throws InterruptedException, ExecutionException{
    return firebaseServiceBeer.saveBeerDetails(beer);
  }

  @PutMapping("/updateBeer")
  public String putExample(@RequestBody Beer beer) throws ExecutionException, InterruptedException {
    return firebaseServiceBeer.updateBeerDetails(beer);
  }
}
