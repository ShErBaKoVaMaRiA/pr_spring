package com.example.pr_spring_1.Repository;

import com.example.pr_spring_1.Models.Constellations;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ConstellationsRepository extends CrudRepository<Constellations,Long> {
    Constellations findByName(String Name);
    public List<Constellations> findByNameContains (String Name);
}
