package com.proj.finHelper.DTO.LenderDTO;

import com.proj.finHelper.entity.Lender;
import com.proj.finHelper.enums.LenderType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LenderRequestDTO {

    @NotBlank
    private String name;

    @NotNull
    private LenderType type;

    private String gstNo;
    private String rbiLicenceNo;


}
