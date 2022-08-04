package com.fabrick.rest.testv5.models.responses;

import com.fabrick.rest.testv5.models.ModelBaseTest;
import com.fabrick.rest.testv5.models.response.GenericResponse;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GenericResponseTest extends ModelBaseTest {

    private void verifyCorrectness(GenericResponse sut) {
        assertThat(sut).isNotNull();
        assertThat(sut.getStatus()).isNotNull().isEqualTo(status);
        assertThat(sut.getErrors()).isNotNull().hasSize(1);
        assertThat(sut.getErrors().get(0).getCode()).isNotNull().isEqualTo(code);
    }

    @Test
    public void ValidPayload_CreatedBySetter() {
        verifyCorrectness(createGenericResponseBySetter());
    }

    @Test
    public void ValidPayload_CreatedByCode() {
        verifyCorrectness(createGenericResponseByConstructor());
    }
}
