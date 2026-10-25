package com.proj.finHelper.DTO.LenderDTO;

import com.proj.finHelper.entity.Lender;
import com.proj.finHelper.enums.LenderType;
import com.proj.finHelper.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LenderResponseDTO {

    private String name;
    private LenderType type;
    private String landerCode;
    private Status status;

    public static LenderResponseDTO lenderResponseDTO(Lender lender){
        LenderResponseDTO lenderResponseDTO = new LenderResponseDTO();
        lenderResponseDTO.setName(lender.getName());
        lenderResponseDTO.setType(lender.getType());
        lenderResponseDTO.setStatus(lender.getStatus());
        lenderResponseDTO.setLanderCode(lender.getLenderCode());
        return lenderResponseDTO;
    }
}
