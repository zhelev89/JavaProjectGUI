package com.example.myBarSystemAPI.services;

import com.example.myBarSystemAPI.exceptions.DuplicateRecordException;
import com.example.myBarSystemAPI.exceptions.NotFoundRecordException;
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

    public User findById(Integer id) {
        return userRepository.findById(id).orElseThrow(
                () -> new NotFoundRecordException(String.format("User with id:%s, not found", id)));
    }

    public User findByName(String name) {
        return userRepository.findByName(name).orElseThrow(
                () -> new NotFoundRecordException(String.format("User with name: %s, not found", name)));
    }

    public User update(User updated, Integer id) {
        User selectedUser = findById(id);
        User updatedUser = new User();
        selectedUser.setName(updatedUser.getName());
        selectedUser.setPhone(updatedUser.getPhone());
        selectedUser.setUserType(updatedUser.getUserType());
        selectedUser.setPin(updated.getPin());
        return selectedUser;
    }

    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }
    
}
