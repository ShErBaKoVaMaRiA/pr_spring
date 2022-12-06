package com.example.pr_spring_1.Models;

import javax.persistence.*;

@Entity
@Table(name = "meteors_planet")
public class Meteors {
        @Id
        //   @GeneratedValue(strategy = GenerationType.IDENTITY)
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long IDMeteors;
        private  String name;
        @OneToOne(optional = true, cascade = CascadeType.ALL)
        @JoinColumn(name="planetID")
        private Planet planet;


    public Meteors() {
    }

    public Meteors(String name, Planet planet) {
        this.name = name;
        this.planet = planet;
    }

    public Long getIDMeteors() {
        return IDMeteors;
    }

    public void setIDMeteors(Long IDMeteors) {
        this.IDMeteors = IDMeteors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Planet getPlanet() {
        return planet;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }
}

