package com.fabrick.rest.testv5.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MoneyTransferRequest {
    private Creditor creditor;
    private String executionDate;
    private String uri;
    private String description;
    private Float amount;
    private String currency;
    @JsonProperty("isUrgent")
    private boolean isUrgent;
    @JsonProperty("isInstant")
    private boolean isInstant;
    private String feeType;
    private String feeAccountId;
    private TaxRelief taxRelief;
}
