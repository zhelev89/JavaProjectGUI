package com.example.myBarSystemAPI.services.Implements;

import com.example.myBarSystemAPI.exceptions.DuplicateRecordException;
import com.example.myBarSystemAPI.exceptions.NotFoundRecordException;
import com.example.myBarSystemAPI.models.User;
import com.example.myBarSystemAPI.models.UserType;
import com.example.myBarSystemAPI.repositories.UserTypeRepository;
import com.example.myBarSystemAPI.services.UserTypeService;
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
public class UserTypeServiceImplTest {

    @Mock
    private UserTypeRepository userTypeRepository;

    private UserTypeServiceImpl userTypeServiceImpl;

    @BeforeEach
    void setUp() {
        userTypeServiceImpl = new UserTypeServiceImpl(userTypeRepository);
    }

    @Test
    void verifySaveThrowNullPointerException() {

        Assertions.assertThrows(NullPointerException.class,
                () -> userTypeServiceImpl.save(null));
    }

    @Test
    void verifySaveThrowDuplicateRecordException() {
        UserType userType = new UserType();

        String expectedMessage = String.format("UserType with type:%s, is already exist", userType.getType());

        Mockito.when(userTypeRepository.save(userType))
                .thenThrow(DataIntegrityViolationException.class);

        DuplicateRecordException exception = Assertions.assertThrows(DuplicateRecordException.class,
                () -> userTypeServiceImpl.save(userType));

        Assertions.assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void verifySaveSuccess() {
        UserType userType = new UserType();
        userTypeServiceImpl.save(userType);

        Mockito.verify(userTypeRepository, Mockito.times(1)).save(userType);
    }

    @Test
    void verifyFindAll() {
        userTypeServiceImpl.findAll();

        Mockito.verify(userTypeRepository, Mockito.times(1)).findAll();
    }

    @Test
    void verifyFindByIdThrowNullPointerException() {

        Assertions.assertThrows(NullPointerException.class,
                () -> userTypeServiceImpl.findById(null));
    }

    @Test
    void verifyFindByIdThrowNotFoundRecordException() {
        Integer id = 1;
        String expectedMessage = String.format("UserType with id:%s, not found", id);

        NotFoundRecordException exception = Assertions.assertThrows(NotFoundRecordException.class,
                () -> userTypeServiceImpl.findById(id));

        Assertions.assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void verifyFindByIdSuccess() {
        Integer id = 1;
        Mockito.when(userTypeRepository.findById(id))
                .thenReturn(Optional.of(UserType.builder()
                        .id(id)
                        .build()));

        userTypeServiceImpl.findById(id);

        Mockito.verify(userTypeRepository, Mockito.times(1)).findById(id);
    }

    @Test
    void verifyFindByTypeThrowNullPointerException() {

        Assertions.assertThrows(NullPointerException.class,
                () -> userTypeServiceImpl.findByType(null));
    }

    @Test
    void verifyFindByNameThrowNotFoundException() {
        String type = "Admin";
        String expectedMessage = String.format("UserType with type:%s, not found", type);

        NotFoundRecordException exception = Assertions.assertThrows(NotFoundRecordException.class,
                () -> userTypeServiceImpl.findByType(type));

        Assertions.assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void verifyFindByNameSuccess() {
        String type = "Admin";

        Mockito.when(userTypeRepository.findByType(type))
                .thenReturn(Optional.of(UserType.builder()
                        .type(type)
                        .build()));

        userTypeServiceImpl.findByType(type);

        Mockito.verify(userTypeRepository, Mockito.times(1)).findByType(type);
    }

    @Test
    void verifyUpdateThrowExceptionWhenUpdateUserIsNull() {
        UserType updatedUserType = null;
        Assertions.assertThrows(NullPointerException.class,
                () -> userTypeServiceImpl.update(updatedUserType, updatedUserType.getId()));
    }

    @Test
    void verifyUpdateThrowExceptionWhenUpdatedUserIdIsNull() {
        UserType userType = new UserType();

        Assertions.assertThrows(NullPointerException.class,
                () -> userTypeServiceImpl.update(userType, userType.getId()));
    }

    @Test
    void deleteById() {
        Integer id = 1;
        userTypeServiceImpl.deleteById(id);

        Mockito.verify(userTypeRepository, Mockito.times(1)).deleteById(id);
    }
}
