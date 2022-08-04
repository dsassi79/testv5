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
public class GenericResponse {
    @ApiModelProperty(notes = "Status. Typically OK or KO, but left as a string and not an enum 'cause we lack info about it", example = "OK", required = true)
    private String status;
    @ApiModelProperty(notes = "List of errors", example = "[]", required = true)
    private ErrorsResponse errors;
}
