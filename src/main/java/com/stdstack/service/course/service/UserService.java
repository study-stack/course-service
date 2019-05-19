package com.stdstack.service.course.service;

import com.stdstack.service.course.model.UserEntity;

public interface UserService {

    UserEntity getUserByUsername(String username);
}
