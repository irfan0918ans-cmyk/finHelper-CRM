package com.proj.finHelper.DTO.AdminCreateDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdminCreateRequestDTO {

    @NotNull
    private Integer superAdminId;

    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;
    private String phone;

    @NotBlank
    @Size(min = 8, message = "Password  must be at least 8 Characters")
    private String password;

}
