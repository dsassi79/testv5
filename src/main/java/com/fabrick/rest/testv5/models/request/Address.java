package com.fabrick.rest.testv5.models.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Address {
    @ApiModelProperty(notes = "Address", example = "Via Foscolo 3", required = true)
    private String address;
    @ApiModelProperty(notes = "City", example = "Milano", required = true)
    private String city;
    @ApiModelProperty(notes = "Country Code", example = "IT", required = true)
    private String countryCode;
}
