package com.example.pr_spring_1.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Meteor {
    @Id
    //@GeneratedValue(strategy= GenerationType.IDENTITY)
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long UID;

    private String name_meteor;
    private String class_meteor;
    private String location_meteor;
    private String weight;
    private String color_meteor;

    public Meteor() {
    }

    public Meteor(String name_meteor, String class_meteor, String location_meteor, String weight, String color_meteor) {
        this.name_meteor = name_meteor;
        this.class_meteor = class_meteor;
        this.location_meteor = location_meteor;
        this.weight = weight;
        this.color_meteor = color_meteor;
    }

    public Long getUID() {
        return UID;
    }

    public void setUID(Long UID) {
        this.UID = UID;
    }

    public String getName_meteor() {
        return name_meteor;
    }

    public void setName_meteor(String name_meteor) {
        this.name_meteor = name_meteor;
    }

    public String getClass_meteor() {
        return class_meteor;
    }

    public void setClass_meteor(String class_meteor) {
        this.class_meteor = class_meteor;
    }

    public String getLocation_meteor() {
        return location_meteor;
    }

    public void setLocation_meteor(String location_meteor) {
        this.location_meteor = location_meteor;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getColor_meteor() {
        return color_meteor;
    }

    public void setColor_meteor(String color_meteor) {
        this.color_meteor = color_meteor;
    }
}