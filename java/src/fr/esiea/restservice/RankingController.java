package fr.esiea.restservice;

import fr.esiea.model.Ranking;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RankingController {

    @GetMapping
    public Ranking ranking(@RequestParam(value = "ranking", defaultValue = "week") String range){
        return new Ranking(range);
    }


}
