package com.proj.finHelper.controller;

import com.proj.finHelper.DTO.AdminCreateDTO.AdminCreateRequestDTO;
import com.proj.finHelper.DTO.AdminCreateDTO.AdminCreateResponseDTO;
import com.proj.finHelper.service.AdminService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@AllArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/CreateAdmin")
    public ResponseEntity<AdminCreateResponseDTO> adminCreateController(@Valid @RequestBody AdminCreateRequestDTO adminCreateRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(adminService.createAdminService(adminCreateRequestDTO));
    }

    @GetMapping("/getAdmin")
    public ResponseEntity<List<AdminCreateResponseDTO>> getAllAdminController(@Valid @RequestParam Integer superAdminId){
        return ResponseEntity.status(HttpStatus.OK)
                .body(adminService.getAllAdminService(superAdminId));
    }

}
