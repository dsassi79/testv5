package com.fabrick.rest.testv5.models.responses;

import com.fabrick.rest.testv5.models.ModelBaseTest;
import com.fabrick.rest.testv5.models.response.Transaction;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TransactionTest extends ModelBaseTest {

    private void verifyCorrectness(Transaction sut) {
        assertThat(sut).isNotNull();
        assertThat(sut.getDescription()).isNotNull().isEqualTo(description);
        assertThat(sut.getAccountingDate()).isNotNull().isEqualTo(accountingDate);
        assertThat(sut.getTransactionId()).isNotNull().isEqualTo(transactionId);
        assertThat(sut.getAmount()).isNotNull().isEqualTo(amount);
        assertThat(sut.getCurrency()).isNotNull().isEqualTo(currency);
        assertThat(sut.getType().getValue()).isNotNull().isEqualTo(value);
        assertThat(sut.getValueDate()).isNotNull().isEqualTo(valueDate);
        assertThat(sut.getTransactionId()).isNotNull().isEqualTo(transactionId);
        assertThat(sut.getOperationId()).isNotNull().isEqualTo(operationId);
    }

    @Test
    public void ValidPayload_CreatedBySetter() {
        verifyCorrectness(createTransactionBySetter());
    }

    @Test
    public void ValidPayload_CreatedByCode() {
        verifyCorrectness(createTransactionByConstructor());
    }
}

