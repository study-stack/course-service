package com.stdstack.service.course.courseservice.service.impl;

import com.stdstack.service.course.courseservice.model.Course;
import com.stdstack.service.course.courseservice.model.Step;
import com.stdstack.service.course.courseservice.model.StepData;
import com.stdstack.service.course.courseservice.model.UserCourseStep;
import com.stdstack.service.course.courseservice.model.enums.StepType;
import com.stdstack.service.course.courseservice.repository.CourseRepository;
import com.stdstack.service.course.courseservice.repository.StepRepository;
import com.stdstack.service.course.courseservice.repository.UserCourseStepRepository;
import com.stdstack.service.course.courseservice.service.CourseService;
import com.stdstack.service.course.courseservice.service.StepValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StepValidationServiceImpl implements StepValidationService {

    private final UserCourseStepRepository userCourseStepRepository;
    private final CourseRepository courseRepository;
    private final StepRepository stepRepository;
    private final CourseService courseService;

    @Override
    public Step checkStep(Long userId, Long courseId, Object input) {
        Course course = courseRepository.getOne(courseId);
        UserCourseStep courseStep = userCourseStepRepository.findByCurrentTrueAndCourseAndUserId(course, userId);
        Step curStep = courseStep.getStep();
        StepData stepData = curStep.getStepData();
        if (curStep.getType().equals(StepType.THEORY)) {
            return courseService.goNextStepForCourse(courseId, userId);
        } else if (curStep.getType().equals(StepType.SELECT_ANSWER)) {
            Long answerId = Long.valueOf(String.valueOf(input));
            if (stepData.getQuestion().getCorrectAnswer().getId().equals(answerId)) {
                return courseService.goNextStepForCourse(courseId, userId);
            }
        }
        throw new RuntimeException("Step cannot be processed");
    }
}
