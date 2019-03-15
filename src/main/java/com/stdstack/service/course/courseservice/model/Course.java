package com.stdstack.service.course.courseservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "courses")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"}, ignoreUnknown = true)
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    private String skills;

    private String prerequisites;

    @OneToMany(mappedBy = "course")
    private List<Step> steps;

    @OneToMany(mappedBy = "course")
    private Set<UserCourseStep> userCourseSteps;

    public List<String> getSkills() {
        return Arrays.asList(skills.split(";"));
    }

    public List<String> getPrerequisites() {
        return Arrays.asList(prerequisites.split(";"));
    }
}
