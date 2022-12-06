package com.example.pr_spring_1.Models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@Entity
public class Star {
    @Id
    //@GeneratedValue(strategy= GenerationType.IDENTITY)
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long UID;
    @NotBlank(message =  "Поле не может быть пустым")
    private String name;
    @NotEmpty(message =  "Поле не может быть пустым")
    private String class_star;
    @Positive(message="Свет не может быть отрицательным")
    private Integer lumen;
    public Star() {

    }

    public Star(String name, String class_star, Integer lumen) {
        this.name = name;
        this.class_star = class_star;
        this.lumen = lumen;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getClass_star() {
        return class_star;
    }

    public void setClass_star(String class_star) {
        this.class_star = class_star;
    }

    public Integer getLumen() {
        return lumen;
    }

    public void setLumen(Integer lumen) {
        this.lumen = lumen;
    }

}
