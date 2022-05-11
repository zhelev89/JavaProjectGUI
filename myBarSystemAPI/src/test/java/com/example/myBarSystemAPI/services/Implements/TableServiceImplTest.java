package com.example.myBarSystemAPI.services.Implements;

import com.example.myBarSystemAPI.exceptions.DuplicateRecordException;
import com.example.myBarSystemAPI.exceptions.NotFoundRecordException;
import com.example.myBarSystemAPI.models.Table;
import com.example.myBarSystemAPI.models.User;
import com.example.myBarSystemAPI.repositories.TableRepository;
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
public class TableServiceImplTest {

    @Mock
    private TableRepository tableRepository;

    private TableServiceImpl tableServiceImpl;

    @BeforeEach
    void setUp() {
        tableServiceImpl = new TableServiceImpl(tableRepository);
    }

    @Test
    void verifySaveThrowNullPointerException() {
        Table table = null;

        Assertions.assertThrows(NullPointerException.class,
                () -> tableServiceImpl.save(table));
    }

    @Test
    void verifySaveThrowDuplicateRecordException() {
        Table table = new Table();

        Mockito.when(tableServiceImpl.save(table))
                .thenThrow(DataIntegrityViolationException.class);

        String expectedMessage = String.format(
                "Table with number %s, already exist.", table.getNumber());

        DuplicateRecordException exception = Assertions.assertThrows(DuplicateRecordException.class,
                () -> tableServiceImpl.save(table));

        Assertions.assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void verifySaveSuccess() {
        Table table = new Table();
        tableServiceImpl.save(table);

        Mockito.verify(tableRepository, Mockito.times(1)).save(table);
    }

    @Test
    void verifyFindAll() {
        tableServiceImpl.findAll();

        Mockito.verify(tableRepository, Mockito.times(1)).findAll();
    }

    @Test
    void verifyFindByIdThrowNullPointerException() {
        Integer id = null;

        Assertions.assertThrows(NullPointerException.class,
                () -> tableServiceImpl.findById(id));
    }

    @Test
    void verifyFindByIdThrowNotFoundRecordException() {
        Integer id = 1;
        String expectedMessage = String.format("Table with id:%s, not found", id);

        NotFoundRecordException exception = Assertions.assertThrows(NotFoundRecordException.class,
                () -> tableServiceImpl.findById(id));

        Assertions.assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void verifyFindByIdSuccess() {
        Integer id = 1;
        Mockito.when(tableRepository.findById(id))
                .thenReturn(Optional.of(Table.builder()
                        .id(id)
                        .build()));

        tableServiceImpl.findById(id);

        Mockito.verify(tableRepository, Mockito.times(1)).findById(id);
    }

    @Test
    void verifyFindByNumberThrowNullPointerException() {
        Integer number = null;

        Assertions.assertThrows(NullPointerException.class,
                () -> tableServiceImpl.findByNumber(number));
    }

    @Test
    void verifyFindByNumberThrowNotFoundRecordException() {
        Integer number = 1;
        String expectedMessage = String.format("Table with number:%s, not found", number);

        NotFoundRecordException exception = Assertions.assertThrows(NotFoundRecordException.class,
                () -> tableServiceImpl.findByNumber(number));

        Assertions.assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void verifyFindByNumberSuccess() {
        Integer number = 1;
        Mockito.when(tableRepository.findByNumber(number))
                .thenReturn(Optional.of(Table.builder()
                        .number(number)
                        .build()));

        tableServiceImpl.findByNumber(number);
        Mockito.verify(tableRepository, Mockito.times(1)).findByNumber(1);
    }

    @Test
    void verifyDeleteById() {
        Integer number = 1;
        tableServiceImpl.deleteByNumber(number);

        Mockito.verify(tableRepository, Mockito.times(1)).deleteByNumber(number);
    }
}
