package com.fabrick.rest.testv5.models.request;

import com.fabrick.rest.testv5.models.ModelBaseTest;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LegalPersonBeneficiaryTest extends ModelBaseTest {

    private void verifyCorrectness(LegalPersonBeneficiary sut) {
        assertThat(sut).isNotNull();
        assertThat(sut.getFiscalCode()).isNotNull().isEqualTo(fiscalCode);
        assertThat(sut.getLegalRepresentativeFiscalCode()).isNotNull().isEqualTo(legalRepresentativeFiscalCode);
    }

    @Test
    public void ValidPayload_CreatedBySetter() {
        verifyCorrectness(createLegalPersonBeneficiaryBySetter());
    }

    @Test
    public void ValidPayload_CreatedByCode() {
        verifyCorrectness(createLegalPersonBeneficiaryByConstructor());
    }
}
