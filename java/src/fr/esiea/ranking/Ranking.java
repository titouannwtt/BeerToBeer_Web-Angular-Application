package fr.esiea.ranking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ranking {
    
    
    
    public ArrayList<String> top = new ArrayList<>();
    
    public Ranking(String range){
        // Requête votes
    }
    
    public void makeRank(HashMap<String, Integer> votes){
        votes.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEachOrdered(c -> top.add(c.getKey()));
    }
    
    public List<String> getTop(){
        return top;
    }
    
}
