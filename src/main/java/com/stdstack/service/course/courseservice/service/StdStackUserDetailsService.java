package com.stdstack.service.course.courseservice.service;

import com.stdstack.service.course.courseservice.model.StdStackUser;
import com.stdstack.service.course.courseservice.repository.OAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class StdStackUserDetailsService implements UserDetailsService {

    @Autowired
    private OAuthRepository userRepository;

    @Override
    public StdStackUser loadUserByUsername(String username) throws UsernameNotFoundException {
        return new StdStackUser(userRepository.getUserDetails(username));
    }
} 