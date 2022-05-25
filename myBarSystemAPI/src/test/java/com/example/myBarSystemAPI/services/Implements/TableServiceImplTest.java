package com.example.myBarSystemAPI.services.Implements;

import com.example.myBarSystemAPI.repositories.TableRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

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
    void verifyFindAll() {
        tableServiceImpl.findAll();

        Mockito.verify(tableRepository, Mockito.times(1)).findAll();
    }
}
