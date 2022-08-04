package com.fabrick.rest.testv5.models.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class GenericResponseWithGenericPayload extends GenericResponse {
    private Object payload;

    public GenericResponseWithGenericPayload(String status, ErrorsResponse errors, Object payload) {
        super(status, errors);
        this.payload = payload;
    }
}
