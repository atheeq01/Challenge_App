package com.something.ChallengeApp.repository;

import com.something.ChallengeApp.model.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ChallengeRepository extends JpaRepository<Challenge,Long> {

    List<Challenge> findByMonthIgnoreCase(String month);
}
