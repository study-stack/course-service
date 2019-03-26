package com.stdstack.service.course.courseservice.service;

import com.stdstack.service.course.courseservice.model.Step;

public interface StepValidationService {

    Step checkStep(Long userId, Long courseId, Object input);
}
