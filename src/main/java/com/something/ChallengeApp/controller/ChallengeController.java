package com.something.ChallengeApp.controller;

import com.something.ChallengeApp.model.Challenge;
import com.something.ChallengeApp.service.ChallengeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping("/challenges")
public class ChallengeController {

    private ChallengeService challengeService;

    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @GetMapping()
    public ResponseEntity<List<Challenge>> getChallenges(){;
        return new ResponseEntity<>(challengeService.getChallenges(),HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<String> createChallenge(@RequestBody Challenge challenge){
        String msg = challengeService.createChallenges(challenge);
        return new ResponseEntity<>(msg,HttpStatus.CREATED);
    }
    @GetMapping("/{month}")
    public ResponseEntity<List<Challenge>> getChallenge(@PathVariable String month){
        List<Challenge> challenge =  challengeService.getChallenge(month);

        if (challenge!=null)
            return new ResponseEntity<>(challenge, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateChallenge(@RequestBody Challenge challenge ,
                                                  @PathVariable Long id){
        try {
            String msg = challengeService.updateChallenge(challenge, id);
            return new ResponseEntity<>(msg, HttpStatus.OK);
        }catch (ResponseStatusException e){
            return new ResponseEntity<>(e.getMessage(),e.getStatusCode());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteChallenge(@PathVariable Long id){
        try {
            String msg = challengeService.deleteChallenge(id);
            return new ResponseEntity<>(msg, HttpStatus.OK);
        }catch (ResponseStatusException e){
            return new ResponseEntity<>(e.getMessage(),e.getStatusCode());
        }
    }


}
