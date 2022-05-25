package com.example.myBarSystemAPI.services.Implements;

import com.example.myBarSystemAPI.models.User;
import com.example.myBarSystemAPI.repositories.UserRepository;
import com.example.myBarSystemAPI.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

}
