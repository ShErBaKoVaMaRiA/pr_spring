package com.example.pr_spring_1.Repository;

import com.example.pr_spring_1.Models.Planet;
import org.springframework.data.repository.CrudRepository;

public interface PlanetRepository extends CrudRepository<Planet, Long> {

}
