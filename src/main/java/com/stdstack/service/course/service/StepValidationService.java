package com.stdstack.service.course.service;

import com.stdstack.service.course.model.Step;

public interface StepValidationService {

    Step checkStep(Long userId, Long courseId, Object input);
    Step checkStep(String username, Long courseId, Object input);
}
