package com.stdstack.service.course.courseservice.service.impl;

import com.stdstack.service.course.courseservice.model.Course;
import com.stdstack.service.course.courseservice.model.Step;
import com.stdstack.service.course.courseservice.model.UserCourseStep;
import com.stdstack.service.course.courseservice.repository.CourseRepository;
import com.stdstack.service.course.courseservice.repository.StepRepository;
import com.stdstack.service.course.courseservice.repository.UserCourseStepRepository;
import com.stdstack.service.course.courseservice.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final UserCourseStepRepository userCourseStepRepository;
    private final CourseRepository courseRepository;
    private final StepRepository stepRepository;

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

    /**
     * Enter or continue work with step course
     * @param courseId
     * @param userId
     * @return
     */
    @Override
    @Transactional
    public Step enterTheCourse(Long courseId, Long userId) {
        Course course = courseRepository.getOne(courseId);
        Step currentStep = getCurrentStepForCourse(course, userId);
        if (currentStep == null) {
//            init
            // create 1st step
            Step firstStep = stepRepository.findFirstStep(course);
            UserCourseStep ucs = UserCourseStep.builder()
                    .course(course)
                    .userId(userId)
                    .step(firstStep)
                    .build();
            userCourseStepRepository.saveAndFlush(ucs);

            return firstStep;
        }
        // returns the current step to create UI for it. e.g step#10
        return currentStep;
    }


}
