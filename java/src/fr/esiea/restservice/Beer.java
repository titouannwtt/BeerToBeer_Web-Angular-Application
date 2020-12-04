package fr.esiea;

public class Beer {
  private String name;

  private String alcool;

  private String nbvote;

  public Beer() {
    super();
  }
  public Beer(String name, String alcool, String nbvote) {
    super();
    this.name = name;
    this.alcool = alcool;
    this.nbvote = nbvote;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAlcool() {
    return alcool;
  }

  public void setAlcool(String alcool) {
    this.alcool = alcool;
  }

  public String getNbVote() {
    return nbvote;
  }

  public void setNbVote(String nbVote) {
    this.nbvote = nbvote;
  }



}

