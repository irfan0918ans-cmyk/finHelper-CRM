package com.proj.finHelper.controller;


import com.proj.finHelper.DTO.LenderDTO.LenderRequestDTO;
import com.proj.finHelper.DTO.LenderDTO.LenderResponseDTO;
import com.proj.finHelper.service.LenderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/lender")
@RequiredArgsConstructor
public class LenderController {

    private  final LenderService lenderService;

    @PostMapping("/register")
    public ResponseEntity<LenderResponseDTO> lenderRegistrationController(@Valid @RequestBody LenderRequestDTO lenderRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(lenderService.lenderRegistrationService(lenderRequestDTO));
    }
}
