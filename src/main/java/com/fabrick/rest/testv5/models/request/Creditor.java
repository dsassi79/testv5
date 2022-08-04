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
public class Creditor {
    @ApiModelProperty(notes = "Name", example = "Mario Rossi", required = true)
    private String name;
    @ApiModelProperty(notes = "Account", example = "{}", required = true)
    private Account account;
    @ApiModelProperty(notes = "Address", example = "{}", required = true)
    private Address address;
}
