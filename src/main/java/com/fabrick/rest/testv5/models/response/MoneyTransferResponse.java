package com.fabrick.rest.testv5.models.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class MoneyTransferResponse extends GenericResponse {
    private MoneyTransferPayload payload;

    public MoneyTransferResponse(String status, ErrorsResponse errors, MoneyTransferPayload payload) {
        super(status, errors);
        this.payload = payload;
    }
}
