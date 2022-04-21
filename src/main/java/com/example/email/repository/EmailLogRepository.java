package com.example.email.repository;

import com.example.email.entity.EmailLog;
import com.example.email.entity.Segment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmailLogRepository extends JpaRepository<EmailLog, Long> {
    List<EmailLog> findByStatus(String status);
}
