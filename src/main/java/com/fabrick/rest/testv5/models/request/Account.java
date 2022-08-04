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
public class Account {
    @ApiModelProperty(notes = "Account Code", example = "IT23A0336844430152923804660", required = true)
    private String accountCode;
    @ApiModelProperty(notes = "Bic Code", example = "SELBIT2BXXX", required = true)
    private String bicCode;


}
