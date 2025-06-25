package com.something.ChallengeApp.service;

import com.something.ChallengeApp.model.Challenge;
import com.something.ChallengeApp.repository.ChallengeRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class ChallengeService implements ChallengeServiceInter{

    public ChallengeRepository challengeRepository;

    public ChallengeService(ChallengeRepository challengeRepository) {
        this.challengeRepository = challengeRepository;
    }

    @Override
    public  List<Challenge> getChallenges() {
        return challengeRepository.findAll();
    }

    @Override
    public String createChallenges(Challenge challenge) {
        if (challenge != null) {
            challengeRepository.save(challenge);
            return "created successfully";
        }else
            return "created unsuccessfully";

    }

    @Override
    public List<Challenge> getChallenge(String month) {
        List<Challenge> foundChallenges = challengeRepository.findByMonthIgnoreCase(month);
        return foundChallenges.isEmpty()?null:foundChallenges;
    }

    @Override
    public String updateChallenge(Challenge challenge, Long id) {
        challengeRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Resource Not Found..."));
        challenge.setId(id);
        challengeRepository.save(challenge);
        return "successfully updated"+challenge.toString();
    }

    public String deleteChallenge(Long id) {
        Challenge challenge = challengeRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found..."));
        challengeRepository.delete(challenge);
        return "successfully deleted";
    }

}
