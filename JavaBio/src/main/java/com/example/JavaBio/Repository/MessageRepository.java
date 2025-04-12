package com.example.JavaBio.Repository;

import com.example.JavaBio.Entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByRequestId(Long requestId);
}
