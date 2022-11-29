package com.example.pr_spring_1.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class Planet {
    @Id
    //@GeneratedValue(strategy= GenerationType.IDENTITY)
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long UID;
    @NotEmpty(message =  "Поле не может быть пустым")
    private String name_planet;

    @Positive(message="Вес не может быть отрицательным")
    private float weight_planet;
    @NotNull(message =  "Поле не может быть пустым")
    private String sputnik_planet;
    @NotBlank(message =  "Поле не может быть пустым")
    private String rotation_period;
    @Min(value = -900,message = "Число должно быть больше -900 градусов")
    private float temperature;

    public Planet() {
    }

    public Planet(String name_planet, float weight_planet, String sputnik_planet, String rotation_period, float temperature) {
        this.name_planet = name_planet;
        this.weight_planet = weight_planet;
        this.sputnik_planet = sputnik_planet;
        this.rotation_period = rotation_period;
        this.temperature = temperature;
    }

    public Long getUID() {
        return UID;
    }

    public void setUID(Long UID) {
        this.UID = UID;
    }

    public String getName_planet() {
        return name_planet;
    }

    public void setName_planet(String name_planet) {
        this.name_planet = name_planet;
    }

    public float getWeight_planet() {
        return weight_planet;
    }

    public void setWeight_planet(float weight_planet) {
        this.weight_planet = weight_planet;
    }

    public String getSputnik_planet() {
        return sputnik_planet;
    }

    public void setSputnik_planet(String sputnik_planet) {
        this.sputnik_planet = sputnik_planet;
    }

    public String getRotation_period() {
        return rotation_period;
    }

    public void setRotation_period(String rotation_period) {
        this.rotation_period = rotation_period;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }
}
