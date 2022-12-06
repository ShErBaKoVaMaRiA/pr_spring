package com.example.pr_spring_1.Models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
    @Table(name = "stars_constellations")
    public class Stars {
        @Id
        //   @GeneratedValue(strategy = GenerationType.IDENTITY)
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name="ID_Stars")
        private Long ID_Stars;
        @NotBlank(message = "Строка не должна быть пустой")
        @Column(name="name")
        private String name;

        @ManyToOne(optional = true, cascade = CascadeType.ALL)
        private Constellations constellations;


        public Long getID_Stars() {
            return ID_Stars;
        }

        public void setID_Stars(Long StarsID) {
            this.ID_Stars = StarsID;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }



        public Stars(String name, Constellations constellations) {
            this.name = name;
            this.constellations = constellations;
        }

        public Stars() {
        }
    }
