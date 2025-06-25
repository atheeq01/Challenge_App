package com.something.ChallengeApp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Challenge {

    @Id
    private Long id;

    @Column(name ="challengeMonth")
    private String month;
    private String description;

    public Challenge(Long id, String month, String description) {
        this.id = id;
        this.month = month;
        this.description = description;
    }

    public Challenge() {

    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getMonth() {
//        return month;
//    }
//
//    public void setMonth(String month) {
//        this.month = month;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }

    @Override
    public String toString() {
        return "\nChallenge{" +
                "\nid=" + id +
                "\nmonth='" + month + '\'' +
                "\ndescription='" + description + '\'' +
                "\n}";
    }
}
