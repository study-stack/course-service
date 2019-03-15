package com.stdstack.service.course.courseservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "steps")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Step {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @Column(name = "short_description")
    private String shortDescription;

    @ManyToOne
    @JoinColumn(name = "course_id")
    @JsonIgnore
    private Course course;

    @OneToOne
    @JsonIgnore
    private Step next;

    @OneToOne
    @JsonIgnore
    private Step prev;

    @OneToMany(mappedBy = "step")
    @JsonIgnore
    private Set<UserCourseStep> userCourseSteps;

    public Step switchToNext() {
        Step next = this.next;
        this.prev = next;
        this.next = next.getNext();
        return next;
    }

    public Step switchToPrev() {
        Step prev = this.prev;
        this.next = prev;
        this.prev = prev.getPrev();
        return prev;
    }
}
