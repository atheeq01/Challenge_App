package com.something.ChallengeApp.service;

import com.something.ChallengeApp.model.Challenge;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChallengeService implements ChallengeServiceInter{
    private List<Challenge> challenges= new ArrayList<>();

    long id = 1L;

    @Override
    public  List<Challenge> getChallenges() {
        return challenges;
    }

    @Override
    public String createChallenges(Challenge challenge) {
        if (challenge != null) {
            challenge.setId(id++);
            challenges.add(challenge);
            return "created successfully";
        }else
            return "created unsuccessfully";

    }

    @Override
    public List<Challenge> getChallenge(String month) {
        if(month ==null){
            return Collections.emptyList();
        }

        return challenges.stream()
                .filter(challenge -> month.equalsIgnoreCase(challenge.getMonth()))
                .collect(Collectors.toList());
    }

    @Override
    public String updateChallenge(Challenge challenge, Long id) {
        Challenge challengeFound= (Challenge) challenges.stream()
                .filter(challenge1 -> challenge1.getId().equals(id))
                .findFirst()
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found..."));
        challengeFound.setId(id);
        challengeFound.setMonth(challenge.getMonth());
        challengeFound.setDescription(challenge.getDescription());
        return "successfully updated"+challengeFound.toString();
    }

    public String deleteChallenge(Long id) {
        boolean bool = challenges.removeIf(challenge1 -> challenge1.getId().equals(id));
        if (!bool)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found...");
        return "successfully deleted";
    }

}
