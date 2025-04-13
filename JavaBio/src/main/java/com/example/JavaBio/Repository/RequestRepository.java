package com.example.JavaBio.Repository;

import com.example.JavaBio.Entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RequestRepository extends JpaRepository<Request, Long> {
    List<Request> findByStatus(String Status);

}
