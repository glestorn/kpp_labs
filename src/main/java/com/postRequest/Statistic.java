package com.postRequest;

public class Statistic {

    private int requestAmount;
    private long invalidInputs;
    private String longestRequest;
    private String shortestRequest;
    private String mostPopularRequest;

    public void setRequestAmount(int requestAmount) {
        this.requestAmount = requestAmount;
    }

    public int getRequestAmount() {
        return requestAmount;
    }

    public void setInvalidInputs(long invalidInputs) {
        this.invalidInputs = invalidInputs;
    }

    public long getInvalidInputs() {
        return invalidInputs;
    }

    public void setLongestRequest(String longestRequest) {
        this.longestRequest = longestRequest;
    }

    public String getLongestRequest() {
        return longestRequest;
    }

    public void setShortestRequest(String shortestRequest) {
        this.shortestRequest = shortestRequest;
    }

    public String getShortestRequest() {
        return shortestRequest;
    }

    public void setMostPopularRequest(String mostPopularRequest) {
        this.mostPopularRequest = mostPopularRequest;
    }

    public String getMostPopularRequest() {
        return mostPopularRequest;
    }
}
