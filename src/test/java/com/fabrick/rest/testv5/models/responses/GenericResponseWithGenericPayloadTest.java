package com.fabrick.rest.testv5.models.responses;

import com.fabrick.rest.testv5.models.ModelBaseTest;
import com.fabrick.rest.testv5.models.response.GenericResponse;
import com.fabrick.rest.testv5.models.response.GenericResponseWithGenericPayload;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GenericResponseWithGenericPayloadTest extends ModelBaseTest {

    private void verifyCorrectness(GenericResponseWithGenericPayload sut) {
        assertThat(sut).isNotNull();
        assertThat(sut.getStatus()).isNotNull().isEqualTo(status);
        assertThat(sut.getErrors()).isNotNull().hasSize(1);
        assertThat(sut.getErrors().get(0).getCode()).isNotNull().isEqualTo(code);
        assertThat(sut.getPayload()).isNotNull();
    }

    @Test
    public void ValidPayload_CreatedBySetter() {
        verifyCorrectness(createGenericResponseWithGenericPayloadBySetter());
    }

    @Test
    public void ValidPayload_CreatedByCode() {
        verifyCorrectness(createGenericResponseWithGenericPayloadByConstructor());
    }
}
