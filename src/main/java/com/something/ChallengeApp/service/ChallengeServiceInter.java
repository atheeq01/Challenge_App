package com.something.ChallengeApp.service;

import com.something.ChallengeApp.model.Challenge;

import java.util.List;

public interface ChallengeServiceInter {
    List<Challenge> getChallenges();
    String createChallenges(Challenge challenge);

    List<Challenge> getChallenge(String month);

    String updateChallenge(Challenge challenge, Long id);
    String deleteChallenge(Long id);
}
