package com.fabrick.rest.testv5.exceptions;

import com.fabrick.rest.testv5.models.ModelBaseTest;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GenericExceptionTest extends ModelBaseTest {

    private void verifyCorrectness(GenericException sut) {
        assertThat(sut).isNotNull();
        assertThat(sut.getCode()).isNotNull().isEqualTo(code);
        assertThat(sut.getMessage()).isNotNull().isEqualTo(description);
    }

    @Test
    public void ValidPayload_CreatedBySetter() {
        verifyCorrectness(createGenericExceptionBySetter());
    }

    @Test
    public void ValidPayload_CreatedByCode() {
        verifyCorrectness(createGenericExceptionByConstructor());
    }
}
