package com.example.pr_spring_1.Models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Collection;

@Entity
@Table(name = "constellation")
public class Constellations {
    @Id
    //   @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID_Constellation;

    @Column(name="name")
    private  String name;

    @OneToMany(mappedBy = "constellations", fetch = FetchType.EAGER)
    private Collection<Stars> stars;

    public Constellations() {
    }


    public Collection<Stars> getStars() {
        return stars;
    }

    public void setStars(Collection<Stars> stars) {
        this.stars = stars;
    }


    public Long getID_Constellation() {
        return ID_Constellation;
    }

    public void setID_Constellation(Long ID_Constellation) {
        this.ID_Constellation = ID_Constellation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public void setStar(Collection<Stars> stars) {
        this.stars = stars;
    }
}
