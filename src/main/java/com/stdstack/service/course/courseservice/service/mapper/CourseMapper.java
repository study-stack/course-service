package com.stdstack.service.course.courseservice.service.mapper;

import com.stdstack.service.course.courseservice.dto.CourseInfoDTO;
import com.stdstack.service.course.courseservice.model.Course;
import com.stdstack.service.course.courseservice.model.Step;
import com.stdstack.service.course.courseservice.repository.CourseRepository;
import com.stdstack.service.course.courseservice.repository.UserCourseStepRepository;
import com.stdstack.service.course.courseservice.service.CourseService;
import lombok.RequiredArgsConstructor;
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

    public CourseInfoDTO courseToCourseDTO(Long courseId, Long userId) {
        CourseInfoDTO courseInfoDTO = new CourseInfoDTO();
        Course course = courseRepository.getOne(courseId);
        Step currentStep = courseService.getCurrentStepForCourse(course, userId);


        courseInfoDTO.setCurrentStep(currentStep);
        courseInfoDTO.setDescription(course.getDescription());
        courseInfoDTO.setId(courseId);
        courseInfoDTO.setName(course.getName());
        courseInfoDTO.setPrerequisites(course.getPrerequisites());
        courseInfoDTO.setSkills(course.getSkills());
        courseInfoDTO.setSteps(course.getSteps());
        return courseInfoDTO;
    }

    public List<CourseInfoDTO> getCoursesDTO(Long userId) {
        return courseRepository.findAll()
                .stream()
                .map(course -> courseToCourseDTO(course.getId(), userId))
                .collect(Collectors.toList());
    }
}
