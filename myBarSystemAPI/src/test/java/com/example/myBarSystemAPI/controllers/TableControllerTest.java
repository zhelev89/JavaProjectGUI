package com.example.myBarSystemAPI.controllers;

import com.example.myBarSystemAPI.converters.TableConverter;
import com.example.myBarSystemAPI.dataTransferObjects.tables.TableResponse;
import com.example.myBarSystemAPI.dataTransferObjects.tables.TableSaveRequest;
import com.example.myBarSystemAPI.models.Table;
import com.example.myBarSystemAPI.services.TableService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TableController.class)
public class TableControllerTest extends BaseControllerTest {

    @MockBean
    private TableService tableService;

    @MockBean
    private TableConverter tableConverter;

    @Test
    void verifySave() throws Exception {
        TableSaveRequest tableSaveRequest = new TableSaveRequest();
        tableSaveRequest.setNumber(1);

        String tableJson = objectMapper.writeValueAsString(tableSaveRequest);

        when(tableConverter.convert(any(TableSaveRequest.class)))
                .thenReturn(Table.builder().build());

        when(tableService.save(any(Table.class)))
                .thenReturn(Table.builder().build());

        when(tableConverter.convert(any(Table.class)))
                .thenReturn(TableResponse.builder()
                        .id(1)
                        .number(tableSaveRequest.getNumber())
                        .build());

        mockMvc.perform(post("/tables")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(tableJson))
                .andExpect(status().isCreated())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.number", is(tableSaveRequest.getNumber())));
    }

    @Test
    void verifyFindAll() throws Exception {
        mockMvc.perform(get("/tables"))
                .andExpect(status().isFound())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    void verifyFindByNumber() throws Exception {
        Integer number = 1;
        String numberJson = objectMapper.writeValueAsString(number);

        when(tableService.findByNumber(number))
                .thenReturn(Table.builder()
                        .number(number)
                        .build());

        when(tableConverter.convert(any(Table.class)))
                .thenReturn(TableResponse.builder()
                        .id(1)
                        .number(number)
                        .build());

        mockMvc.perform(get("/tables/number/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(numberJson))
                .andExpect(status().isFound())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.number", is(number)));
    }
}
