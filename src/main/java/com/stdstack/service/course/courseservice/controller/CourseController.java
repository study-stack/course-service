package com.stdstack.service.course.courseservice.controller;

import com.stdstack.service.course.courseservice.model.Course;
import com.stdstack.service.course.courseservice.repository.CourseRepository;
import com.stdstack.service.course.courseservice.util.UserInfo;
import com.stdstack.service.course.courseservice.util.WithUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.impl.DefaultClaims;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CourseController {

    private final CourseRepository courseRepository;

    @GetMapping(value = "courses")
    public List<Course> getCourses() {
        return null;
    }

    @GetMapping(value = "courses/{id}")
    public Course getCourse(@PathVariable Long id, @WithUser UserInfo userInfo) {
        return courseRepository.getOne(id);
    }

}
