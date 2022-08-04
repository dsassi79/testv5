package com.fabrick.rest.testv5.models.request;

import com.fabrick.rest.testv5.models.ModelBaseTest;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest extends ModelBaseTest {

    private void verifyCorrectness(Account sut) {
        assertThat(sut).isNotNull();
        assertThat(sut.getAccountCode()).isNotNull().isEqualTo(accountCode);
        assertThat(sut.getBicCode()).isNotNull().isEqualTo(bicCode);
    }

    @Test
    public void ValidPayload_CreatedBySetter() {
        verifyCorrectness(createAccountBySetter());
    }

    @Test
    public void ValidPayload_CreatedByCode() {
        verifyCorrectness(createAccountByConstructor());
    }
}
