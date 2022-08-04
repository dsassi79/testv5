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
public class MoneyTransferPayload {
    @ApiModelProperty(notes = "Status", example = "EXECUTED", required = true)
    private String status;
    //Qui andrebbero mappate tutte le altre proprietà ma per questioni di tempo mi sono limitato
}
