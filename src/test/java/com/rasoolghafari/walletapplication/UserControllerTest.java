package com.rasoolghafari.walletapplication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rasoolghafari.walletapplication.controllers.UserController;
import com.rasoolghafari.walletapplication.dto.UserDTO;
import com.rasoolghafari.walletapplication.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @Test
    public void testCreateUser() throws Exception {
        UserDTO userDTO = new UserDTO(1L, "Rasool", "+989371234567");

        when(userService.createUser(any(UserDTO.class))).thenReturn(userDTO);

        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        mockMvc.perform(MockMvcRequestBuilders.post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(userDTO)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.id").value(userDTO.id()))
                .andExpect(jsonPath("$.name").value(userDTO.name()))
                .andExpect(jsonPath("$.phoneNumber").value(userDTO.phoneNumber()));

        verify(userService, times(1)).createUser(any(UserDTO.class));
    }

    @Test
    public void testGetUserById() throws Exception {
        UserDTO userDTO = new UserDTO(1L, "Rasool", "+989371234567");

        when(userService.find(eq(1L))).thenReturn(userDTO);

        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/users/find/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.id").value(userDTO.id()))
                .andExpect(jsonPath("$.name").value(userDTO.name()))
                .andExpect(jsonPath("$.phoneNumber").value(userDTO.phoneNumber()));

        verify(userService, times(1)).find(eq(1L));
    }

    private String asJsonString(Object obj) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }
}