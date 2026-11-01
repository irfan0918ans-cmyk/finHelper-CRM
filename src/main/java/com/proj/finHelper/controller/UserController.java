package com.proj.finHelper.controller;

import com.proj.finHelper.DTO.UserDTO.LoginRequestDTO;
import com.proj.finHelper.DTO.UserDTO.LoginResponseDTO;
import com.proj.finHelper.DTO.UserDTO.SuperAdminRequestDTO;
import com.proj.finHelper.DTO.UserDTO.UserResponseDTO;
import com.proj.finHelper.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {

    private  final UserService userService;

    @PostMapping("/super-admin-create")
    public ResponseEntity<UserResponseDTO> createSuperAdminController(@Valid @RequestBody SuperAdminRequestDTO superAdminRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.createSuperAdminService(superAdminRequestDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> loginUserController(@Valid @RequestBody LoginRequestDTO loginRequestDTO){
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.loginUser(loginRequestDTO));
    }
}
