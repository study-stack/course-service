package com.stdstack.service.course.courseservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "step_data")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StepData {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "multiple_answer")
    private Boolean multipleAnswer;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    private String content;

    @OneToOne
    private Question question;
}
