package com.fabrick.rest.testv5.models.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class GetTransactionsResponse extends GenericResponse {
    private TransactionsPayload payload;

    public GetTransactionsResponse(String status, ErrorsResponse errors, TransactionsPayload payload) {
        super(status, errors);
        this.payload = payload;
    }
}
