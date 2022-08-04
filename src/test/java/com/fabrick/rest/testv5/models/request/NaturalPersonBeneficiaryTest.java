package com.fabrick.rest.testv5.models.request;

import com.fabrick.rest.testv5.models.ModelBaseTest;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NaturalPersonBeneficiaryTest extends ModelBaseTest {

    private void verifyCorrectness(NaturalPersonBeneficiary sut) {
        assertThat(sut).isNotNull();
        assertThat(sut.getFiscalCode1()).isNotNull().isEqualTo(fiscalCode1);
        assertThat(sut.getFiscalCode2()).isNotNull().isEqualTo(fiscalCode2);
        assertThat(sut.getFiscalCode3()).isNotNull().isEqualTo(fiscalCode3);
        assertThat(sut.getFiscalCode4()).isNotNull().isEqualTo(fiscalCode4);
        assertThat(sut.getFiscalCode5()).isNotNull().isEqualTo(fiscalCode5);
    }

    @Test
    public void ValidPayload_CreatedBySetter() {
        verifyCorrectness(createNaturalPersonBeneficiaryBySetter());
    }

    @Test
    public void ValidPayload_CreatedByCode() {
        verifyCorrectness(createNaturalPersonBeneficiaryByConstructor());
    }
}
