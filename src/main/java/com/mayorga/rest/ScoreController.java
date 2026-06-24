package com.mayorga.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ScoreController {
	
	static Score score = new Score(30, 20, 10);

	@GetMapping("/health")
	public String getHelthCheck() {
		return "Up!";
	}
	
	@PatchMapping("/score/wins")
	public Score updateWins(@RequestParam(name="new-value")int newValue) {
		score.wins = newValue;
		return score;
	}
	
	@PutMapping("/score")
	public Score updateScore(@RequestBody Score newScore) {
		score = newScore;
		return score;
	}
	
	@PostMapping("/score/wins")
	public Score increaseScore() {
		score.wins++;
		return score;
	}
	
	@GetMapping("/score")
	public Score getScore() {
		return score;
	}
	
	@GetMapping("/score/{status}")
	public int getRequestedStatus(@PathVariable String status) {
		if (status.equalsIgnoreCase("wins")) {
			return score.wins;
		}
		if (status.equalsIgnoreCase("ties")) {
			return score.ties;
		}
		
		return score.losses	;
	}
	
}
