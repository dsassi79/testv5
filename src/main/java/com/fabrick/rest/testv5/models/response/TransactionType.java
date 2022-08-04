package com.fabrick.rest.testv5.models.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TransactionType {
    @ApiModelProperty(notes = "Enumeration of the type", example = "GBS_TRANSACTION_TYPE", required = true)
    private String enumeration;
    @ApiModelProperty(notes = "Value of the type", example = "GBS_ACCOUNT_TRANSACTION_TYPE_0009", required = true)
    private String value;
}
