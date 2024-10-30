package com.java_db_example.data;

public class Votes {
    private int id;
    private int voterId;
    private int candidateId;
    private String isVoted;
    private String reason;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVoterId() {
        return voterId;
    }

    public void setVoterId(int voterId) {
        this.voterId = voterId;
    }

    public int getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }

    public String getIsVoted() {
        return isVoted;
    }

    public void setIsVoted(String isVoted) {
        this.isVoted = isVoted;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
