package com.example.myBarSystemAPI.controllers;

import com.example.myBarSystemAPI.dataTransferObjects.users.UserResponse;
import com.example.myBarSystemAPI.dataTransferObjects.users.UserSaveRequest;
import com.example.myBarSystemAPI.models.User;
import com.example.myBarSystemAPI.services.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTest extends BaseControllerTest{

    @MockBean
    private UserService userService;

    @MockBean
    private UserConverter userConverter;

    @Test
    void verifySave() throws Exception {
        UserSaveRequest userSaveRequest = new UserSaveRequest();
        userSaveRequest.setName("Zhivko Zhelev");
        userSaveRequest.setPhone("0899123123");
        userSaveRequest.setPinCode("0000");

        String userSaveRequestJson = objectMapper.writeValueAsString(userSaveRequest);
        Mockito.when(userConverter.convert(Mockito.any(UserSaveRequest.class)))
                .thenReturn(User.builder().build());

        Mockito.when(userService.save(Mockito.any(User.class)))
                .thenReturn(User.builder().build());

        Mockito.when(userConverter.convert(Mockito.any(User.class)))
                .thenReturn(UserResponse.builder()
                        .name(userSaveRequest.getName())
                        .phone(userSaveRequest.getPhone())
                        .pinCode(userSaveRequest.getPinCode())
                        .build());

        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userSaveRequestJson))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is(userSaveRequest.getName())));
    }

    @Test
    void verifyFindAll() throws Exception {
        mockMvc.perform(get("/users"))
                .andExpect(status().isFound())
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    void verifyFindByName() throws Exception {
        String name = "Gosho";
        String usernameJson = objectMapper.writeValueAsString(name);

        Mockito.when(userService.findByName(name))
                .thenReturn(User.builder()
                        .name(name)
                        .build());

        Mockito.when(userConverter.convert(Mockito.any(User.class)))
                .thenReturn(UserResponse.builder()
                        .name(name)
                        .build());

        mockMvc.perform(get("http://localhost:8080/users/name/Gosho")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(usernameJson))
                .andExpect(status().isFound())
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is(name)));
    }

    @Test
    void verifyDeleteById() throws Exception {
        Integer id = 1;
        String idJson = objectMapper.writeValueAsString(id);

        mockMvc.perform(delete("/users/id/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(idJson))
                .andExpect(status().isGone());
    }
}
