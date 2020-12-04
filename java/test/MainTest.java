import fr.esiea.model.Ranking;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class MainTest {
    
    @Test
    public void TestRank(){
        Random rand = new Random();
        String[] noms = {"Heineken","Beer","Duff","Corona","Leffe","Arti"};
        HashMap<String, Integer> map = new HashMap<>();
    
        Arrays.stream(noms).forEach(c -> map.put(c, rand.nextInt(10000)));
        map.forEach((key, value) -> System.out.println(key + ":" + value));
        Ranking rank = new Ranking("week");
        rank.makeRank(map);
        
        System.out.println("Ranking :");
        rank.getTop().forEach(System.out::println);
    }
    
}
