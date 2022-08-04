package com.fabrick.rest.testv5.models.responses;

import com.fabrick.rest.testv5.models.ModelBaseTest;
import com.fabrick.rest.testv5.models.response.TransactionType;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TransactionTypeTest extends ModelBaseTest {

    private void verifyCorrectness(TransactionType sut) {
        assertThat(sut).isNotNull();
        assertThat(sut.getEnumeration()).isNotNull().isEqualTo(enumeration);
        assertThat(sut.getValue()).isNotNull().isEqualTo(value);
    }

    @Test
    public void ValidPayload_CreatedBySetter() {
        verifyCorrectness(createTransactionTypeBySetter());
    }

    @Test
    public void ValidPayload_CreatedByCode() {
        verifyCorrectness(createTransactionTypeByConstructor());
    }
}
