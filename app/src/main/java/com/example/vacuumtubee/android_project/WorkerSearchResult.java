package com.example.vacuumtubee.android_project;

/**
 * Created by NIT on 4/25/2016.
 */
public class WorkerSearchResult {
    String name;
    String phoneNumber;
    String address;

    public WorkerSearchResult(String name, String phoneNumber, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    @Override
    public String toString() {
        return "WorkerSearchResult{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
