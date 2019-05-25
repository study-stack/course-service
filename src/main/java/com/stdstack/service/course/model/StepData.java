package com.stdstack.service.course.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "step_data")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StepData {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "multiple_answer")
    private Boolean multipleAnswer;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    private String content;

    @OneToOne
    private Question question;
}
