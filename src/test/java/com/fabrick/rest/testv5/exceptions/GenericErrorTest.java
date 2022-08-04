package com.fabrick.rest.testv5.exceptions;

import com.fabrick.rest.testv5.models.ModelBaseTest;
import com.fabrick.rest.testv5.models.response.TransactionType;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GenericErrorTest extends ModelBaseTest {

    private void verifyCorrectness(GenericError sut) {
        assertThat(sut).isNotNull();
        assertThat(sut.getCode()).isNotNull().isEqualTo(code);
        assertThat(sut.getDescription()).isNotNull().isEqualTo(description);
    }

    @Test
    public void ValidPayload_CreatedBySetter() {
        verifyCorrectness(createGenericErrorBySetter());
    }

    @Test
    public void ValidPayload_CreatedByCode() {
        verifyCorrectness(createGenericErrorByConstructor());
    }
}
