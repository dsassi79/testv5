package com.fabrick.rest.testv5.models.responses;

import com.fabrick.rest.testv5.models.ModelBaseTest;
import com.fabrick.rest.testv5.models.response.GetTransactionsResponse;
import com.fabrick.rest.testv5.models.response.MoneyTransferResponse;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTransferResponseTest extends ModelBaseTest {

    private void verifyCorrectness(MoneyTransferResponse sut) {
        assertThat(sut).isNotNull();
        assertThat(sut.getStatus()).isNotNull().isEqualTo(status);
        assertThat(sut.getErrors()).isNotNull().hasSize(1);
        assertThat(sut.getErrors().get(0).getCode()).isNotNull().isEqualTo(code);
        assertThat(sut.getPayload()).isNotNull();
        //assertThat(sut.getPayload().isConfirmed()).isEqualTo(confirmed);
    }

    @Test
    public void ValidPayload_CreatedBySetter() {
        verifyCorrectness(createMoneyTransferResponseBySetter());
    }

    @Test
    public void ValidPayload_CreatedByCode() {
        verifyCorrectness(createMoneyTransferResponseByConstructor());
    }
}
