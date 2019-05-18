package com.stdstack.service.course.courseservice.service;

import com.stdstack.service.course.courseservice.model.Course;
import com.stdstack.service.course.courseservice.model.Step;
import com.stdstack.service.course.courseservice.model.UserEntity;

public interface UserService {

    UserEntity getUserByUsername(String username);
}
