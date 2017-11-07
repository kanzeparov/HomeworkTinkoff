package com.example.franck.fintechhomework.FirstPoint;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Franck on 05.11.2017.
 */

public class User {
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @SerializedName("name")
    @Expose
    private String firstName;
    @SerializedName("lastName")
    private String lastName;



}