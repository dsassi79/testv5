package com.fabrick.rest.testv5.exceptions;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GenericError {
    @ApiModelProperty(notes = "Code of the error", example = "API000", required = true)
    private String code;
    @ApiModelProperty(notes = "Description of the error", example = "it.sella.pagamenti.servizibonifico.exception.ServiziInvioBonificoSubsystemException: it.sella.pagamenti.sottosistemi.SottosistemiException: Errore tecnico CONTO 45685475:Conto 45685475 non esiste", required = true)
    private String description;
}
