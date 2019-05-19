package com.stdstack.service.course.service.impl;

import com.stdstack.service.course.model.UserEntity;
import com.stdstack.service.course.repository.UserRepository;
import com.stdstack.service.course.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserEntity getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
