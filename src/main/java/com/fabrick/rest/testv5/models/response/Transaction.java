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
public class Transaction {
    @ApiModelProperty(notes = "Id of the transaction", example = "OK", required = true)
    private String transactionId;
    @ApiModelProperty(notes = "id of the operation", example = "OK", required = true)
    private String operationId;
    @ApiModelProperty(notes = "Accounting date", example = "OK", required = true)
    private String accountingDate;
    @ApiModelProperty(notes = "Value Date", example = "OK", required = true)
    private String valueDate;
    @ApiModelProperty(notes = "Type of transaction", example = "OK", required = true)
    private TransactionType type;
    @ApiModelProperty(notes = "Amount", example = "OK", required = true)
    private Float amount;
    @ApiModelProperty(notes = "Currency", example = "OK", required = true)
    private String currency;
    @ApiModelProperty(notes = "Description of the transaction", example = "OK", required = true)
    private String description;
}
