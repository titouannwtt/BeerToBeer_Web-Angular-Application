package fr.esiea.restservice;

import fr.esiea.Beer;

public class User {


  private final String id;
  private final String username;
  private final String pass;


  public User(String id, String username, String pass) {
    this.id = id;
    this.username = username;
    this.pass = pass;
  }

  public String getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public String getPass() {
    return pass;
  }

  public void voteBeer(Beer b){
    b.setNbVote("1");
  }

}
