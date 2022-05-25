package com.example.myBarSystemAPI.services.Implements;

import com.example.myBarSystemAPI.exceptions.DuplicateRecordException;
import com.example.myBarSystemAPI.exceptions.NotFoundRecordException;
import com.example.myBarSystemAPI.models.User;
import com.example.myBarSystemAPI.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Optional;

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
    void verifySaveThrowNullPointerException() {
        User user = null;

        Assertions.assertThrows(NullPointerException.class,
                () -> userServiceImpl.save(user));
    }

    @Test
    void verifySaveThrowDuplicateRecordException() {
        User user = new User();

        String expectedMessage = String.format("User with name:%s, already exist.", user.getName());

        Mockito.when(userRepository.save(user))
                .thenThrow(DataIntegrityViolationException.class);

        DuplicateRecordException exception = Assertions.assertThrows(DuplicateRecordException.class,
                () -> userServiceImpl.save(user));

        Assertions.assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void verifySaveSuccess() {
        User user = new User();
        userServiceImpl.save(user);

        Mockito.verify(userRepository, Mockito.times(1)).save(user);
    }

    @Test
    void verifyFindAll() {
        userServiceImpl.findAll();

        Mockito.verify(userRepository, Mockito.times(1)).findAll();
    }

    @Test
    void verifyFindByIdThrowNullPointerException() {
        Integer id = null;

        Assertions.assertThrows(NullPointerException.class,
                () -> userServiceImpl.findById(id));
    }

    @Test
    void verifyFindByIdThrowNotFoundRecordException() {
        Integer id = 1;
        String expectedMessage = String.format("User with id:%s, not found", id);

        NotFoundRecordException exception = Assertions.assertThrows(NotFoundRecordException.class,
                () -> userServiceImpl.findById(id));

        Assertions.assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void verifyFindByIdSuccess() {
        Integer id = 1;
        Mockito.when(userRepository.findById(id))
                .thenReturn(Optional.of(User.builder()
                        .id(id)
                        .build()));

        userServiceImpl.findById(id);

        Mockito.verify(userRepository, Mockito.times(1)).findById(id);
    }

    @Test
    void verifyFindByNameThrowNullPointerException() {
        String name = null;

        Assertions.assertThrows(NullPointerException.class,
                () -> userServiceImpl.findByName(name));
    }

    @Test
    void verifyFindByNameThrowNotFoundException() {
        String name = "Gosho";
        String expectedMessage = String.format("User with name: %s, not found", name);

        NotFoundRecordException exception = Assertions.assertThrows(NotFoundRecordException.class,
                () -> userServiceImpl.findByName(name));

        Assertions.assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void verifyFindByNameSuccess() {
        String name = "Gosho";

        Mockito.when(userRepository.findByName(name))
                .thenReturn(Optional.of(User.builder()
                        .name(name)
                        .build()));

        userServiceImpl.findByName(name);

        Mockito.verify(userRepository, Mockito.times(1)).findByName(name);
    }

    @Test
    void verifyUpdateThrowExceptionWhenUpdateUserIsNull() {
        User updatedUser = null;
        Assertions.assertThrows(NullPointerException.class,
                () -> userServiceImpl.update(updatedUser, updatedUser.getId()));
    }

    @Test
    void verifyUpdateThrowExceptionWhenUpdatedUserIdIsNull() {
        User user = new User();

        Assertions.assertThrows(NullPointerException.class,
                () -> userServiceImpl.update(user, user.getId()));
    }

    @Test
    void deleteById() {
        Integer id = 1;
        userServiceImpl.deleteById(id);

        Mockito.verify(userRepository, Mockito.times(1)).deleteById(id);
    }
}