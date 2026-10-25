package com.proj.finHelper.DTO.UserDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SuperAdminRequestDTO {

    @NotBlank
    private String lenderCode;

    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;
    private String phone;

    @NotBlank
    private String address;

    @NotBlank
    @Size(min = 8, message = "Password must be At least 8 Character")
    private String password;

}
