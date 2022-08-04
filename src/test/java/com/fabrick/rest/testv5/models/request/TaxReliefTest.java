package com.fabrick.rest.testv5.models.request;

import com.fabrick.rest.testv5.models.ModelBaseTest;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TaxReliefTest extends ModelBaseTest {

    private void verifyCorrectness(TaxRelief sut) {
        assertThat(sut).isNotNull();
        assertThat(sut.getTaxReliefId()).isNotNull().isEqualTo(taxReliefId);
        assertThat(sut.getBeneficiaryType()).isNotNull().isEqualTo(beneficiaryType);
        assertThat(sut.getCreditorFiscalCode()).isNotNull().isEqualTo(creditorFiscalCode);
        assertThat(sut.isCondoUpgrade()).isEqualTo(isCondoUpgrade);
        assertThat(sut.getLegalPersonBeneficiary().getLegalRepresentativeFiscalCode()).isNotNull().isEqualTo(legalRepresentativeFiscalCode);
        assertThat(sut.getNaturalPersonBeneficiary().getFiscalCode1()).isNotNull().isEqualTo(fiscalCode1);
    }

    @Test
    public void ValidPayload_CreatedBySetter() {
        verifyCorrectness(createTaxReliefBySetter());
    }

    @Test
    public void ValidPayload_CreatedByCode() {
        verifyCorrectness(createTaxReliefByConstructor());
    }
}
