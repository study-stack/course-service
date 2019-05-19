package com.stdstack.service.course.dto;

import com.stdstack.service.course.model.Step;
import lombok.Data;

import java.util.List;

@Data
public class CourseInfoDTO {

    private Long id;
    private String name;
    private String description;
    private List<String> skills;
    private List<String> prerequisites;
    private List<Step> steps;
    private Step currentStep = null;


}
