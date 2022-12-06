package com.example.pr_spring_1.Models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Meteor {
    @Id
    //@GeneratedValue(strategy= GenerationType.IDENTITY)
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long UID;

    private String name;

    private String class_meteor;

    private String location_meteor;

    private String weight;

    private String color_meteor;

    @ManyToMany
    @JoinTable(name="meteor_planet",
            joinColumns=@JoinColumn(name="meteor_id"),
            inverseJoinColumns=@JoinColumn(name="planet_id"))
    private List<Planet> planet;

    public List<Planet> getPlanet() {
        return planet;
    }

    public void setPlanet(List<Planet> planet) {
        this.planet = planet;
    }
    public Meteor() {
    }

    public Meteor(String name_meteor, String class_meteor, String location_meteor, String weight, String color_meteor) {
        this.name = name_meteor;
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

    public String getName() {
        return name;
    }

    public void setName(String name_meteor) {
        this.name = name_meteor;
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