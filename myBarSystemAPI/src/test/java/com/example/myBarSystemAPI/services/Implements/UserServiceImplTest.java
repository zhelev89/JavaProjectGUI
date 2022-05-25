package com.example.myBarSystemAPI.services.Implements;

import com.example.myBarSystemAPI.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    private UserServiceImpl userServiceImpl;

    @BeforeEach
    void setUp() {
        userServiceImpl = new UserServiceImpl(userRepository);
    }

    @Test
    void verifyFindAll() {
        userServiceImpl.findAll();

        Mockito.verify(userRepository, Mockito.times(1)).findAll();
    }
}