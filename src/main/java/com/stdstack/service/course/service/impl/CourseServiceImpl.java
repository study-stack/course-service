package com.stdstack.service.course.service.impl;

import com.stdstack.service.course.model.Course;
import com.stdstack.service.course.model.Step;
import com.stdstack.service.course.model.UserCourseStep;
import com.stdstack.service.course.repository.CourseRepository;
import com.stdstack.service.course.repository.StepRepository;
import com.stdstack.service.course.repository.UserCourseStepRepository;
import com.stdstack.service.course.service.CourseService;
import com.stdstack.service.course.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final UserCourseStepRepository userCourseStepRepository;

    private final CourseRepository courseRepository;

    private final StepRepository stepRepository;

    private final UserService userService;

    @Override
    public Step getCurrentStepForCourse(Course course, Long userId) {
        UserCourseStep currentStep = userCourseStepRepository.findByCurrentTrueAndCourseAndUserId(course, userId);
        if (currentStep == null) {
            return null;
        }
        return currentStep.getStep();
    }

    @Override
    @Transactional
    public Step goNextStepForCourse(Long courseId, Long userId) {
        Course course = courseRepository.getOne(courseId);
        UserCourseStep currentStep = userCourseStepRepository.findByCurrentTrueAndCourseAndUserId(course, userId);

        currentStep.setCurrent(false);
        userCourseStepRepository.save(currentStep);
        Step nextStep = currentStep.getStep().getNext();

        UserCourseStep ucs = UserCourseStep.builder()
                                           .course(course)
                                           .userId(userId)
                                           .step(nextStep)
                                           .current(true)
                                           .build();
        userCourseStepRepository.save(ucs);
        return nextStep;
    }

    @Override
    public Step goNextStepForCourse(Long courseId, String username) {
        return goNextStepForCourse(courseId, userService.getUserByUsername(username)
                                                        .getId());
    }

    @Override
    public Step applyCourse(Course course) {
        return null;
    }

    /**
     * Enter or continue work with step course
     *
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
                                               .current(true)
                                               .build();
            userCourseStepRepository.saveAndFlush(ucs);

            return firstStep;
        }
        // returns the current step to create UI for it. e.g step#10
        return currentStep;
    }

    @Override
    public Step enterTheCourse(Long courseId, String username) {
        return enterTheCourse(courseId, userService.getUserByUsername(username)
                                                   .getId());
    }

    @Override
    public boolean isStepAvailable(Long courseId, Long stepId, Long userId) {
        Course course = courseRepository.getOne(courseId);
        Step step = stepRepository.getOne(stepId);
        UserCourseStep courseStep = userCourseStepRepository.findByUserIdAndCourseAndStep(userId, course, step);
        return courseStep != null;
    }

    @Override
    public boolean isCourseAvailable(Long courseId, Long userId) {
        return false;
    }

}
