package com.stdstack.service.course.courseservice.controller;

import com.stdstack.service.course.courseservice.dto.CourseInfoDTO;
import com.stdstack.service.course.courseservice.model.Step;
import com.stdstack.service.course.courseservice.service.CourseService;
import com.stdstack.service.course.courseservice.service.StepValidationService;
import com.stdstack.service.course.courseservice.service.mapper.CourseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    private final CourseMapper courseMapper;

    private final StepValidationService stepValidationService;

    @GetMapping(value = "courses")
    public List<CourseInfoDTO> getCourses(@AuthenticationPrincipal String username) {

        return courseMapper.getCoursesDTO(username);
    }

    @GetMapping(value = "courses/{id}")
    public CourseInfoDTO getCourse(@PathVariable Long id, @AuthenticationPrincipal String username) {
        return courseMapper.courseToCourseDTO(id, username);
    }

    @PostMapping(value = "courses/{id}")
    public Step enterTheCourse(@PathVariable Long id, @AuthenticationPrincipal String username) {
        return courseService.enterTheCourse(id, username);
    }

    @PostMapping(value = "courses/{id}/next")
    public Step nextStep(@PathVariable Long id, @AuthenticationPrincipal String username) {
        return courseService.goNextStepForCourse(id, username);
    }

    @PostMapping(value = "courses/{id}/submit")
    public Step submitStep(@PathVariable Long id, @RequestParam Object input,
                           @AuthenticationPrincipal String username) {
        return stepValidationService.checkStep(username, id, input);
    }

}
