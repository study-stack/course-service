package com.stdstack.service.course.courseservice.repository;

import com.stdstack.service.course.courseservice.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
