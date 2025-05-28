package com.Rakshak.Fullstack.Backend.repository;

import com.Rakshak.Fullstack.Backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
