package com.proj.finHelper.DTO.UserDTO;

import com.proj.finHelper.entity.User;
import com.proj.finHelper.enums.Role;
import com.proj.finHelper.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {

    private String name;
    private String email;
    private Role role;
    private Status status;
    private String landerName;

    public static UserResponseDTO toUserResponseDTO(User user){
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setName(user.getName());
        userResponseDTO.setEmail(user.getEmail());
        userResponseDTO.setRole(user.getRole());
        userResponseDTO.setStatus(user.getStatus());
        userResponseDTO.setLanderName(user.getLender().getName());
        return userResponseDTO;
    }
}
