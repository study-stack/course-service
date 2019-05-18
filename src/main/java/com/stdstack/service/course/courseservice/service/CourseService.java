package com.stdstack.service.course.courseservice.service;

import com.stdstack.service.course.courseservice.model.Course;
import com.stdstack.service.course.courseservice.model.Step;

public interface CourseService {

    Step getCurrentStepForCourse(Course course, Long userId);
    Step goNextStepForCourse(Long courseId, Long userId);
    Step goNextStepForCourse(Long courseId, String username);
    Step applyCourse(Course course);
    Step enterTheCourse(Long courseId, Long userId);
    Step enterTheCourse(Long courseId, String username);
    boolean isStepAvailable(Long courseId, Long stepId, Long userId);
    boolean isCourseAvailable(Long courseId, Long userId);
}
