package com.stdstack.service.course.courseservice.repository;

import com.stdstack.service.course.courseservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
