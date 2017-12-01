package com.example.christhai.fulcrum;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ChrisThai on 11/27/2017.
 */

public class Score {
    private List<Integer> scores;
    private Date currentDate;
    private HashMap<String, Integer> scoreMap;
    private boolean complete = false;


    public Score(){

    }

    public Score(List<Integer> scores, Date currentDate, Integer academicScore,
                  Integer emotionalScore, Integer physicalScore, Integer socialScore) {
        this.scores = scores;
        this.currentDate = currentDate;
        scoreMap = new HashMap<String, Integer>();
        this.scoreMap.put("academicScore",academicScore);
        this.scoreMap.put("emotionalScore",emotionalScore);
        this.scoreMap.put("physicalScore",physicalScore);
        this.scoreMap.put("socialScore",socialScore);
    }

    public List<Integer> getScores() {
        return scores;
    }

    public void setScores(List<Integer> scores) {
        this.scores = scores;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }


    public HashMap<String, Integer> getScoreMap() {
        return scoreMap;
    }

    public void setScoreMap(HashMap<String, Integer> scoreMap) {
        this.scoreMap = scoreMap;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

}
