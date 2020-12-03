package fr.esiea.restservice;

public class Beer {


  private final long id;
  private final String nom;
  private final String description;
  private int nbVote;

  public Beer(long id, String nom, String description, int nbVote) {
    this.id = id;
    this.nom = nom;
    this.description = description;
    this.nbVote = nbVote;
  }

  public String getDescription() {
    return description;
  }

  public int getNbVote() {
    return nbVote;
  }

  public long getId() {
    return id;
  }

  public String getNom() {
    return nom;
  }

  public void setNbVote(){
    nbVote++;
  }


}
