package com.example.vacuumtubee.android_project;

/**
 * Created by NIT on 4/25/2016.
 */
public class WorkerReviewResult {
    String review;
    String rating;
    String employer;

    public WorkerReviewResult(String review, String rating, String employer) {
        this.review = review;
        this.rating = rating;
        this.employer = employer;
    }

    @Override
    public String toString() {
        return "WorkerReviewResult{" +
                "review='" + review + '\'' +
                ", rating='" + rating + '\'' +
                ", employer='" + employer + '\'' +
                '}';
    }
}
