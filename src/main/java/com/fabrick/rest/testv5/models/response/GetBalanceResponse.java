package com.fabrick.rest.testv5.models.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class GetBalanceResponse extends GenericResponse {
    private BalancePayload payload;

    public GetBalanceResponse(String status, ErrorsResponse errors, BalancePayload payload) {
        super(status, errors);
        this.payload = payload;
    }
}
