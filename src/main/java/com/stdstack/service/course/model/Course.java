package com.stdstack.service.course.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.Type;

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
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(length = 2048)
    private String name;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
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
