package com.example.myBarSystemAPI.services;

import com.example.myBarSystemAPI.exceptions.DuplicateRecordException;
import com.example.myBarSystemAPI.models.User;
import com.example.myBarSystemAPI.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public User save(User user) {
        try {
            Objects.requireNonNull(user);
            return userRepository.save(user);
        } catch (DataIntegrityViolationException ex) {
            throw new DuplicateRecordException(
                    String.format("User with name:%s, already exist.", user.getName()));
        }
    }
}
