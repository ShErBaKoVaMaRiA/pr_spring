package com.example.pr_spring_1.Repository;

import com.example.pr_spring_1.Models.Meteor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MeteorRepository extends CrudRepository<Meteor, Long> {
   Meteor findByName(String name_meteor);
   public List<Meteor> findByNameContains(String name_meteor);
//    @Query(value="SELECT * FROM meteor WHERE class_meteor =?1",nativeQuery=true)
//    List<Meteor> selectMeteors(String class_meteor);

}

