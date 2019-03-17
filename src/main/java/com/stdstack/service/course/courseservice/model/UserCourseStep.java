package com.stdstack.service.course.courseservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "user_course_step")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCourseStep {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @ManyToOne
    @JoinColumn(name = "step_id", nullable = false)
    private Step step;

    private Boolean current = false;
}
