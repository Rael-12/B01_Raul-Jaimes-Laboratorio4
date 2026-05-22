package com.axity.dinosaurpark.model;

import lombok.Getter;

@Getter
public class SatisfactionSurvey {
    private int touristId;
    private static int add;
    private String enclosureName;
    private int score;

    public SatisfactionSurvey(int touristId, String enclosureName, int score) {
        validateScore(score);

        this.touristId = add++;
        this.enclosureName = enclosureName;
        this.score = score;
    }

    private static void validateScore(int s){
        if(s <= 0)
            throw new IllegalArgumentException("The score must be greater than zero");

        if(s > 5)
            throw new IllegalArgumentException("The score must be less than or equal to 5");
    }
}
