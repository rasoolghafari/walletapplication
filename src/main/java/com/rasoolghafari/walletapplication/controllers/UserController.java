package com.rasoolghafari.walletapplication.controllers;

import com.rasoolghafari.walletapplication.dto.UserDTO;
import com.rasoolghafari.walletapplication.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@SecurityRequirement(name = "walletapplication")
public class UserController {
    private final UserService service;

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        UserDTO createdUser = service.createUser(userDTO);
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        UserDTO user = service.find(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/list")
    public ResponseEntity<List<UserDTO>> list() {
        return ResponseEntity.ok(service.list());
    }
}