package com.something.ChallengeApp.repository;

import com.something.ChallengeApp.model.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChallengeRepository extends JpaRepository<Challenge,Long> {
}
