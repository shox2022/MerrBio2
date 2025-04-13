package com.example.JavaBio.Repository;

import com.example.JavaBio.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email, String password);

    @Query("SELECT u.role FROM User u WHERE u.email = :email ")
    String findRoleByEmail(@Param("email") String email);

}

