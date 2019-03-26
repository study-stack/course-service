package com.stdstack.service.course.courseservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "questions")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Question {

    @Id
    @GeneratedValue
    private Long id;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    private String content;

    @OneToMany
    private List<AnswerOption> answers;

    @OneToOne
    @JsonIgnore
    private AnswerOption correctAnswer;
}
