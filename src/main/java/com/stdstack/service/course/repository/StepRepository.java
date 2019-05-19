package com.stdstack.service.course.repository;

import com.stdstack.service.course.model.Course;
import com.stdstack.service.course.model.Step;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StepRepository extends JpaRepository<Step, Long> {

    List<Step> findAllByCourse(Course course);


    @Query("from Step where prev is null and course = ?1")
    Step findFirstStep(Course course);
}
