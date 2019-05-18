package com.stdstack.service.course.courseservice.service.mapper;

import com.stdstack.service.course.courseservice.dto.CourseInfoDTO;
import com.stdstack.service.course.courseservice.model.Course;
import com.stdstack.service.course.courseservice.model.Step;
import com.stdstack.service.course.courseservice.repository.CourseRepository;
import com.stdstack.service.course.courseservice.repository.UserCourseStepRepository;
import com.stdstack.service.course.courseservice.service.CourseService;
import com.stdstack.service.course.courseservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CourseMapper {

    private final UserCourseStepRepository userCourseStepRepository;

    private final CourseRepository courseRepository;

    private final CourseService courseService;

    private final UserService userService;

    public CourseInfoDTO courseToCourseDTO(Long courseId, Long userId) {
        Course course = courseRepository.getOne(courseId);
        return courseToCourseDTO(course, userId);
    }

    public CourseInfoDTO courseToCourseDTO(Course course, Long userId) {
        CourseInfoDTO courseInfoDTO = new CourseInfoDTO();

        Step currentStep = courseService.getCurrentStepForCourse(course, userId);
        courseInfoDTO.setCurrentStep(currentStep);
        courseInfoDTO.setDescription(course.getDescription());
        courseInfoDTO.setId(course.getId());
        courseInfoDTO.setName(course.getName());
        courseInfoDTO.setPrerequisites(course.getPrerequisites());
        courseInfoDTO.setSkills(course.getSkills());
        courseInfoDTO.setSteps(course.getSteps());
        return courseInfoDTO;
    }

    public List<CourseInfoDTO> getCoursesDTO(String username) {

        return courseRepository.findAll()
                               .stream()
                               .map(course -> courseToCourseDTO(course.getId(), userService.getUserByUsername(username)
                                                                                           .getId()))
                               .collect(Collectors.toList());
    }

    public CourseInfoDTO courseToCourseDTO(Long id, String username) {
        return courseToCourseDTO(id, userService.getUserByUsername(username)
                                                .getId());
    }
}
