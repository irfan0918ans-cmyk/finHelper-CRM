package com.proj.finHelper.service;

import com.proj.finHelper.DTO.LenderDTO.LenderRequestDTO;
import com.proj.finHelper.DTO.LenderDTO.LenderResponseDTO;

public interface LenderService {

    LenderResponseDTO lenderRegistrationService(LenderRequestDTO lenderRequestDTO);
}
