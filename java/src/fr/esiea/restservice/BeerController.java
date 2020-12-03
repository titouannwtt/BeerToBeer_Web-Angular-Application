package fr.esiea.restservice;

import java.util.concurrent.ExecutionException;

import fr.esiea.service.FireBaseBeer;
import org.springframework.web.bind.annotation.*;


@RestController
public class BeerController {


	@GetMapping("/Beer")
	public String getBeer(@RequestParam String id) throws ExecutionException, InterruptedException {
		return FireBaseBeer.getBeer(id);
	}

}
