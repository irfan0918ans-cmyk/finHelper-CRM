package com.proj.finHelper.DTO.UserDTO;

import com.proj.finHelper.entity.User;
import com.proj.finHelper.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDTO {

    private Integer userId;
    private String name;
    private String email;
    private Role role;
    private Integer lenderId;
    private Integer parentId;

    public static LoginResponseDTO toLoginResponseDto(User user){
        LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
        loginResponseDTO.setName(user.getName());
        loginResponseDTO.setUserId(user.getId());
        loginResponseDTO.setRole(user.getRole());
        loginResponseDTO.setLenderId(user.getLender().getId());
        loginResponseDTO.setLenderId(user.getLender().getId());
        return loginResponseDTO;
    }
}
