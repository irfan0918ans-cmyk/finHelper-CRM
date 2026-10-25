package com.proj.finHelper.ServiceImplementation;

import com.proj.finHelper.DTO.LenderDTO.LenderRequestDTO;
import com.proj.finHelper.DTO.LenderDTO.LenderResponseDTO;
import com.proj.finHelper.entity.Lender;
import com.proj.finHelper.repository.LenderRepository;
import com.proj.finHelper.service.LenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.security.SecureRandom;

@Service
@RequiredArgsConstructor
public class LenderServiceImp implements LenderService {

    private final LenderRepository lenderRepository;
    private final SecureRandom random = new SecureRandom();

    private String generateLenderCode(){
        String code;
        do{
            code = "LAN" + (100000 + random.nextInt(900000));
        }
        while (lenderRepository.existsByLenderCode(code));
        return code;
    }

    @Override
    public LenderResponseDTO lenderRegistrationService(LenderRequestDTO lenderRequestDTO) {
        if (lenderRequestDTO.getGstNo() != null && lenderRepository.existsByGstNo(lenderRequestDTO.getGstNo())){
            throw new ResponseStatusException(HttpStatus.CONFLICT,"GST No. Already Registered");
        }

        if (lenderRequestDTO.getRbiLicenceNo() != null && lenderRepository.existsByRbiLicenceNo(lenderRequestDTO.getRbiLicenceNo())){
            throw new ResponseStatusException(HttpStatus.CONFLICT,"RBL Licence No. Already Exist");
        }

        Lender lender = new Lender();
        lender.setName(lenderRequestDTO.getName());
        lender.setType(lenderRequestDTO.getType());
        lender.setGstNo(lenderRequestDTO.getGstNo());
        lender.setRbiLicenceNo(lenderRequestDTO.getRbiLicenceNo());
        lender.setLenderCode(generateLenderCode());
        lenderRepository.save(lender);

        return LenderResponseDTO.lenderResponseDTO(lender);

    }
}
