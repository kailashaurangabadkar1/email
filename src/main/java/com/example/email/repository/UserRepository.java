package com.example.email.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.email.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
