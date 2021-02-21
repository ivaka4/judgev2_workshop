package com.example.judgev2.workshop.repository;

import com.example.judgev2.workshop.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsernameAndPassword(String username, String password);

    @Query("SELECT u.username FROM users u " + "ORDER BY u.username")
    List<String> findAllUsernames();

    User findByUsername(String username);

    User findUserByGit(String gitAddress);

    boolean findByGit(String gitAddress);


}
