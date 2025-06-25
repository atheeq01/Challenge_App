package com.something.ChallengeApp.model;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
