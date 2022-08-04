package com.fabrick.rest.testv5.models.request;

import com.fabrick.rest.testv5.models.ModelBaseTest;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CreditorTest extends ModelBaseTest {

    private void verifyCorrectness(Creditor sut) {
        assertThat(sut).isNotNull();
        assertThat(sut.getName()).isNotNull().isEqualTo(name);
        assertThat(sut.getAddress().getAddress()).isNotNull().isEqualTo(address);
        assertThat(sut.getAccount().getAccountCode()).isNotNull().isEqualTo(accountCode);
    }

    @Test
    public void ValidPayload_CreatedBySetter() {
        verifyCorrectness(createCreditorBySetter());
    }

    @Test
    public void ValidPayload_CreatedByCode() {
        verifyCorrectness(createCreditorByConstructor());
    }
}
