package com.example.myBarSystemAPI.controllers;

import com.example.myBarSystemAPI.converters.UserTypeConverter;
import com.example.myBarSystemAPI.dataTransferObjects.userTypes.UserTypeResponse;
import com.example.myBarSystemAPI.dataTransferObjects.userTypes.UserTypeSaveRequest;
import com.example.myBarSystemAPI.models.UserType;
import com.example.myBarSystemAPI.services.UserTypeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserTypeController.class)
public class UserTypeControllerTest extends BaseControllerTest {

    @MockBean
    private UserTypeService userTypeService;

    @MockBean
    private UserTypeConverter userTypeConverter;

    @Test
    void verifySave() throws Exception {
        UserTypeSaveRequest userTypeSaveRequest = new UserTypeSaveRequest();
        userTypeSaveRequest.setType("Manager");

        String userTypeSaveRequestJson = objectMapper.writeValueAsString(userTypeSaveRequest);

        when(userTypeConverter.convert(any(UserTypeSaveRequest.class)))
                .thenReturn(UserType.builder().build());

        when(userTypeService.save(any(UserType.class)))
                .thenReturn(UserType.builder().build());

        when(userTypeConverter.convert(any(UserType.class)))
                .thenReturn(UserTypeResponse.builder()
                        .id(1)
                        .type(userTypeSaveRequest.getType())
                        .build());

        mockMvc.perform(post("/userTypes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userTypeSaveRequestJson))
                .andExpect(status().isCreated())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.type", is(userTypeSaveRequest.getType())));
    }

    @Test
    void verifyFindAll() throws Exception {
        mockMvc.perform(get("/userTypes"))
                .andExpect(status().isFound())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    void verifyFindById() throws Exception {
        Integer id = 1;

        String idJson = objectMapper.writeValueAsString(id);

        when(userTypeService.findById(id))
                .thenReturn(UserType.builder()
                        .id(id)
                        .build());

        when(userTypeConverter.convert(any(UserType.class)))
                .thenReturn(UserTypeResponse.builder()
                        .id(id)
                        .build());

        mockMvc.perform(get("/userTypes/id/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(idJson))
                .andExpect(status().isFound())
                .andExpect(jsonPath("$.id", is(id)));
    }

    @Test
    void verifyFindByType() throws Exception {
        String type = "Manager";
        String typeJson = objectMapper.writeValueAsString(type);

        when(userTypeService.findByType(type))
                .thenReturn(UserType.builder()
                        .type(type)
                        .build());

        when(userTypeConverter.convert(any(UserType.class)))
                .thenReturn(UserTypeResponse.builder()
                        .type(type)
                        .build());

        mockMvc.perform(get("/userTypes/type/Manager")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(typeJson))
                .andExpect(status().isFound())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.type", is(type)));
    }

    @Test
    void verifyUpdate() throws Exception {
        UserType updatedUserType = new UserType();
        updatedUserType.setId(1);
        updatedUserType.setType("Manager");

        String updatedUserTypeJson = objectMapper.writeValueAsString(updatedUserType);

        when(userTypeService.update(updatedUserType, updatedUserType.getId()))
                .thenReturn(UserType.builder()
                        .id(updatedUserType.getId())
                        .type(updatedUserType.getType())
                        .build());

        when(userTypeConverter.convert(any(UserType.class)))
                .thenReturn(UserTypeResponse.builder()
                        .id(updatedUserType.getId())
                        .type(updatedUserType.getType())
                        .build());

        mockMvc.perform(put("/userTypes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updatedUserTypeJson))
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$.id", is(updatedUserType.getId())))
                .andExpect(jsonPath("$.type", is(updatedUserType.getType())));
    }

    @Test
    void deleteById() throws Exception {
        Integer id = 1;
        String idJson = objectMapper.writeValueAsString(id);

        mockMvc.perform(delete("/userTypes/id/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(idJson))
                .andExpect(status().isGone());
    }

    @Test
    void deleteByType() throws Exception {
        String type = "Manager";
        String typeJson = objectMapper.writeValueAsString(type);

        mockMvc.perform(delete("/userTypes/type/Manager")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(typeJson))
                .andExpect(status().isGone());
    }
}
