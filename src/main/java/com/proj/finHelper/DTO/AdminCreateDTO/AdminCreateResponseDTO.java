package com.proj.finHelper.DTO.AdminCreateDTO;

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
public class AdminCreateResponseDTO {

    private Integer adminId;
    private String adminName;
    private String email;
    private String phone;
    private Role role;
    private Status status;
    private String lenderName;

    public static AdminCreateResponseDTO toAdminCreateResponseDTO(User user){
        AdminCreateResponseDTO adminCreateResponseDTO = new AdminCreateResponseDTO();
        adminCreateResponseDTO.setAdminId(user.getId());
        adminCreateResponseDTO.setAdminName(user.getName());
        adminCreateResponseDTO.setEmail(user.getEmail());
        adminCreateResponseDTO.setPhone(user.getPhone());
        adminCreateResponseDTO.setRole(user.getRole());
        adminCreateResponseDTO.setStatus(user.getStatus());
        adminCreateResponseDTO.setLenderName(user.getLender().getName());
        return adminCreateResponseDTO;
    }



}
