package com.example.pr_spring_1.Repository;
import com.example.pr_spring_1.Models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    User findByUsername(String username);
}
