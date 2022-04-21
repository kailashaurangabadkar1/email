package com.example.email.repository;

import com.example.email.entity.UserEmailRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEmailRequestRepository extends JpaRepository<UserEmailRequest, Long> {
}
