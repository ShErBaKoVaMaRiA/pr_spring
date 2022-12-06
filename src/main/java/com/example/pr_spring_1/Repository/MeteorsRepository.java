package com.example.pr_spring_1.Repository;

import com.example.pr_spring_1.Models.Meteors;
import org.springframework.data.repository.CrudRepository;

public interface MeteorsRepository extends CrudRepository<Meteors,Long> {
    Meteors findByName(String name);
}
