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
public class BalancePayload {
    @ApiModelProperty(notes = "Date of the balance", example = "2022-07-27", required = true)
    private String date;
    @ApiModelProperty(notes = "Amount", example = "100", required = true)
    private Float balance;
    @ApiModelProperty(notes = "Available Amount", example = "99.90", required = true)
    private Float availableBalance;
    @ApiModelProperty(notes = "Currency", example = "EUR", required = true)
    private String currency;
}
