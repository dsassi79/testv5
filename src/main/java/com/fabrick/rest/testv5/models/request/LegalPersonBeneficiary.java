package com.fabrick.rest.testv5.models.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LegalPersonBeneficiary {
    @ApiModelProperty(notes = "Fiscal Code", example = "", required = true)
    private String fiscalCode;
    @ApiModelProperty(notes = "Legal representative Fiscal Code", example = "", required = true)
    private String legalRepresentativeFiscalCode;
}
