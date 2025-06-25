package com.something.ChallengeApp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Challenge {

    @Id
    private Long id;

    @Column(name ="challengeMonth")
    private String month;
    private String description;

    @Override
    public String toString() {
        return "\nChallenge{" +
                "\nid=" + id +
                "\nmonth='" + month + '\'' +
                "\ndescription='" + description + '\'' +
                "\n}";
    }
}
