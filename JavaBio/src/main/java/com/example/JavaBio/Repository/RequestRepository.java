package com.example.JavaBio.Repository;

import com.example.JavaBio.Entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Long> {
    List<Request> findByStatus(String Status);
}
