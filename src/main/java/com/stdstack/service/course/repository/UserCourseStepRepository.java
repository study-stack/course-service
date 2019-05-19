package com.stdstack.service.course.repository;

import com.stdstack.service.course.model.Course;
import com.stdstack.service.course.model.Step;
import com.stdstack.service.course.model.UserCourseStep;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserCourseStepRepository extends JpaRepository<UserCourseStep, Long> {

    UserCourseStep findByUserIdAndCourseAndStep(Long user, Course course, Step step);

    UserCourseStep findByUserIdAndCourse(Long user, Course course);

    UserCourseStep findByCurrentTrueAndCourseAndUserId(Course course, Long userId);

    List<UserCourseStep> findAllByUserId(Long user);

    List<UserCourseStep> findAllByUserIdAndCourse(Long user, Course course);

    List<UserCourseStep> findAllByUserIdAndStep(Long user, Step step);
}