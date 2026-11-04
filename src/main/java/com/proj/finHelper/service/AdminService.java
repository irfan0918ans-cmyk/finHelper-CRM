package com.proj.finHelper.service;

import com.proj.finHelper.DTO.AdminCreateDTO.AdminCreateRequestDTO;
import com.proj.finHelper.DTO.AdminCreateDTO.AdminCreateResponseDTO;

import java.util.List;

public interface AdminService {

    AdminCreateResponseDTO createAdminService(AdminCreateRequestDTO adminCreateRequestDTO);
    List<AdminCreateResponseDTO> getAllAdmin(Integer superAdminId);
}
