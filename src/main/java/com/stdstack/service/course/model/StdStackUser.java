package com.stdstack.service.course.model;

import org.springframework.security.core.userdetails.User;

/**
 *
 */
public class StdStackUser extends User {
    private static final long serialVersionUID = 1L;
    public StdStackUser(UserEntity user) {
        super(user.getUsername(), user.getPassword(), user.getGrantedAuthoritiesList());
    }
}