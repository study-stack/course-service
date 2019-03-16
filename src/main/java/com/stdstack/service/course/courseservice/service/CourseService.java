package com.stdstack.service.course.courseservice.service;

import com.stdstack.service.course.courseservice.model.Course;
import com.stdstack.service.course.courseservice.model.Step;

public interface CourseService {

    Step getCurrentStepForCourse(Course course, Long userId);
    Step goNextStepForCourse(Course course);
    Step applyCourse(Course course);
    Step enterTheCourse(Long courseId, Long userId);
}
