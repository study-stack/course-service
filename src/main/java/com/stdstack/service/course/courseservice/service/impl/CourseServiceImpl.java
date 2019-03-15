package com.stdstack.service.course.courseservice.service.impl;

import com.stdstack.service.course.courseservice.model.Course;
import com.stdstack.service.course.courseservice.model.Step;
import com.stdstack.service.course.courseservice.model.UserCourseStep;
import com.stdstack.service.course.courseservice.repository.UserCourseStepRepository;
import com.stdstack.service.course.courseservice.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final UserCourseStepRepository userCourseStepRepository;

    @Override
    public Step getCurrentStepForCourse(Course course, Long userId) {
        UserCourseStep currentStep = userCourseStepRepository.findByUserIdAndCourse(userId, course);
        if (currentStep == null) {
            return null;
        }
        return currentStep.getStep();
    }

    @Override
    public Step goNextStepForCourse(Course course) {
        return null;
    }

    @Override
    public Step applyCourse(Course course) {
        return null;
    }
}
