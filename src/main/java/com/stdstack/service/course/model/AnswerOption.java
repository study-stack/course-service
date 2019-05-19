package com.stdstack.service.course.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "answer_option")
public class AnswerOption {

    @Id
    @GeneratedValue
    public Long id;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    public String content;

}
