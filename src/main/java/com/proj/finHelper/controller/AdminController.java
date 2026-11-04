package com.proj.finHelper.controller;

import com.proj.finHelper.DTO.AdminCreateDTO.AdminCreateRequestDTO;
import com.proj.finHelper.DTO.AdminCreateDTO.AdminCreateResponseDTO;
import com.proj.finHelper.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
@AllArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/CreateAdmin")
    public ResponseEntity<AdminCreateResponseDTO> adminCreateController(AdminCreateRequestDTO adminCreateRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(adminService.createAdminService(adminCreateRequestDTO));
    }


}
