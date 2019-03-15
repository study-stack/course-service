package com.stdstack.service.course.courseservice.controller;

import com.stdstack.service.course.courseservice.dto.CourseInfoDTO;
import com.stdstack.service.course.courseservice.repository.CourseRepository;
import com.stdstack.service.course.courseservice.service.mapper.CourseMapper;
import com.stdstack.service.course.courseservice.util.UserInfo;
import com.stdstack.service.course.courseservice.util.WithUser;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CourseController {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    @GetMapping(value = "courses")
    public List<CourseInfoDTO> getCourses(@WithUser UserInfo userInfo) {
        // вернуть дто
        //положить в жвт юезр ид
        return courseMapper.getCoursesDTO(userInfo.getUserId());
    }

    @GetMapping(value = "courses/{id}")
    public CourseInfoDTO getCourse(@PathVariable Long id, @WithUser UserInfo userInfo) {
        return courseMapper.courseToCourseDTO(userInfo.getUserId(), id);
    }

}
