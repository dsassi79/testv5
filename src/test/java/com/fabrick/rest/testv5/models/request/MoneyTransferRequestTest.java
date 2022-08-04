package com.fabrick.rest.testv5.models.request;

import com.fabrick.rest.testv5.models.ModelBaseTest;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTransferRequestTest extends ModelBaseTest {

    private void verifyCorrectness(MoneyTransferRequest sut) {
        assertThat(sut).isNotNull();
        assertThat(sut.getAmount()).isNotNull().isEqualTo(amount);
        assertThat(sut.getCreditor().getName()).isNotNull().isEqualTo(name);
        assertThat(sut.getCurrency()).isNotNull().isEqualTo(currency);
        assertThat(sut.getDescription()).isNotNull().isEqualTo(description);

        assertThat(sut.getExecutionDate()).isNotNull().isEqualTo(executionDate);
        assertThat(sut.getFeeAccountId()).isNotNull().isEqualTo(feeAccountId);
        assertThat(sut.getFeeType()).isNotNull().isEqualTo(feeType);
        assertThat(sut.getUri()).isNotNull().isEqualTo(uri);
        assertThat(sut.getTaxRelief().getTaxReliefId()).isNotNull().isEqualTo(taxReliefId);
        assertThat(sut.isInstant()).isEqualTo(isInstant);
        assertThat(sut.isUrgent()).isEqualTo(isUrgent);
    }

    @Test
    public void ValidPayload_CreatedBySetter() {
        verifyCorrectness(createMoneyTransferRequestBySetter());
    }

    @Test
    public void ValidPayload_CreatedByCode() {
        verifyCorrectness(createMoneyTransferRequestByConstructor());
    }
}
