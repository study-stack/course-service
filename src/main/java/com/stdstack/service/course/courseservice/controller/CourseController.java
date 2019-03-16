package com.stdstack.service.course.courseservice.controller;

import com.stdstack.service.course.courseservice.dto.CourseInfoDTO;
import com.stdstack.service.course.courseservice.model.Step;
import com.stdstack.service.course.courseservice.service.CourseService;
import com.stdstack.service.course.courseservice.service.mapper.CourseMapper;
import com.stdstack.service.course.courseservice.util.UserInfo;
import com.stdstack.service.course.courseservice.util.WithUser;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;
    private final CourseMapper courseMapper;

    @GetMapping(value = "courses")
    public List<CourseInfoDTO> getCourses(@WithUser UserInfo userInfo) {
        return courseMapper.getCoursesDTO(userInfo.getUserId());
    }

    @GetMapping(value = "courses/{id}")
    public CourseInfoDTO getCourse(@PathVariable Long id, @WithUser UserInfo userInfo) {
        return courseMapper.courseToCourseDTO(userInfo.getUserId(), id);
    }

    @PostMapping(value = "courses/{id}")
    public Step enterTheCourse(@PathVariable Long id, @WithUser UserInfo userInfo) {
        return courseService.enterTheCourse(id, userInfo.getUserId());
    }

}
