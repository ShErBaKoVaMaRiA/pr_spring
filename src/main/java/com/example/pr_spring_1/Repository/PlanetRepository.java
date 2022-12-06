package com.example.pr_spring_1.Repository;

import com.example.pr_spring_1.Models.Planet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
public interface PlanetRepository extends CrudRepository<Planet, Long> {
    Planet findByName(String name);
    public List<Planet> findByNameContains(String name);
//    @Query(value="SELECT * FROM planet WHERE class_star =?1",nativeQuery=true)
//    List<Planet> selectStars(String class_planet);

}
