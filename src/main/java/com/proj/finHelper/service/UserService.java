package com.proj.finHelper.service;

import com.proj.finHelper.DTO.UserDTO.LoginRequestDTO;
import com.proj.finHelper.DTO.UserDTO.LoginResponseDTO;
import com.proj.finHelper.DTO.UserDTO.SuperAdminRequestDTO;
import com.proj.finHelper.DTO.UserDTO.UserResponseDTO;

public interface UserService {

    UserResponseDTO createSuperAdminService(SuperAdminRequestDTO superAdminRequestDTO);
    LoginResponseDTO loginUser(LoginRequestDTO loginRequestDTO);
}
