package com.mayorga.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	
	@GetMapping("/score")
	public Score getScore() {
		return score;
	}
	
	@PatchMapping("/score/wins")
	public Score updateWins(@RequestParam(name="new-value")int newValue) {
		score.wins = newValue;
		return score;
	}
	
	@PatchMapping("/score/losses")
	public Score updateLosses(@RequestParam(name="new-value")int newValue) {
		score.losses = newValue;
		return score;
	}
	
	@PatchMapping("/score/ties")
	public Score updateTies(@RequestParam(name="new-value")int newValue) {
		score.ties = newValue;
		return score;
	}
	
//	Not really useful, just to test the HTTP method
	@DeleteMapping("/score")
	public void deleteScore() {
		score = null;
	}
	
	@PutMapping("/score")
	public Score updateScore(@RequestBody Score newScore) {
		score = newScore;
		return score;
	}
	
	@PostMapping("/score/wins")
	public Score increaseWins() {
		score.wins++;
		return score;
	}
	
	@PostMapping("/score/losses")
	public Score increaseLosses() {
		score.losses++;
		return score;
	}
	
	@PostMapping("/score/ties")
	public Score increaseTies() {
		score.ties++;
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
