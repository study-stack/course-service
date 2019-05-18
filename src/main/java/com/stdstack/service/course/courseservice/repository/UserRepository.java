package com.stdstack.service.course.courseservice.repository;

import com.stdstack.service.course.courseservice.model.Course;
import com.stdstack.service.course.courseservice.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUsername(String username);
}
