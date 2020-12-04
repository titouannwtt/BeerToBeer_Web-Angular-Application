package fr.esiea.model;

import java.util.*;

public class Ranking {
    
    
    
    public ArrayList<String> top = new ArrayList<>();
    
    public Ranking(String range){
        // Requête votes
        Random rand = new Random();
        String[] noms = {"Heineken","Beer","Duff","Corona","Leffe","Arti"};
        HashMap<String, Integer> map = new HashMap<>();
        
        Arrays.stream(noms).forEach(c -> map.put(c, rand.nextInt(10000)));
        //map.entrySet().forEach(c -> System.out.println(c.getKey()+":"+c.getValue()));
        this.makeRank(map);
    }
    
    public HashMap<String, Integer> dealVotes(List<String> votes){
        HashMap<String, Integer> res = new HashMap<>();
        for (String s:votes) {
            res.merge(s, 1, Integer::sum);
        }
        return res;
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
