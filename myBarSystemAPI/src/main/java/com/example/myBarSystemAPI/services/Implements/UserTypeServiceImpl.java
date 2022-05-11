package com.example.myBarSystemAPI.services.Implements;

import com.example.myBarSystemAPI.exceptions.DuplicateRecordException;
import com.example.myBarSystemAPI.exceptions.NotFoundRecordException;
import com.example.myBarSystemAPI.models.UserType;
import com.example.myBarSystemAPI.repositories.UserTypeRepository;
import com.example.myBarSystemAPI.services.UserTypeService;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
@AllArgsConstructor
public class UserTypeServiceImpl implements UserTypeService {

    private UserTypeRepository userTypeRepository;

    public UserType save(UserType userType) {
        Objects.requireNonNull(userType);
        try {
            return userTypeRepository.save(userType);
        } catch (DataIntegrityViolationException ex) {
            throw new DuplicateRecordException(
                    String.format("UserType with type:%s, is already exist", userType.getType()));
        }
    }

    public List<UserType> findAll() {
        return userTypeRepository.findAll();
    }

    public UserType findById(Integer id) {
        Objects.requireNonNull(id);
        return userTypeRepository.findById(id).orElseThrow(
                () -> new NotFoundRecordException(
                        String.format("UserType with id:%s, not found", id)));
    }

    public UserType findByType(String type) {
        Objects.requireNonNull(type);
        return userTypeRepository.findByType(type).orElseThrow(
                () -> new NotFoundRecordException(
                        String.format("UserType with type:%s, not found", type)));
    }

    public UserType update(UserType updatedUserType, Integer id) {
        Objects.requireNonNull(updatedUserType);
        Objects.requireNonNull(id);

        UserType selectedUserType = findById(id);
        selectedUserType.setType(updatedUserType.getType());
        return selectedUserType;
    }

    public void deleteById(Integer id) {
        userTypeRepository.deleteById(id);
    }

    public void deleteByType(String type) {
        userTypeRepository.deleteByType(type);
    }
}
