package com.fabrick.rest.testv5.models.responses;

import com.fabrick.rest.testv5.models.ModelBaseTest;
import com.fabrick.rest.testv5.models.response.ErrorResponse;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ErrorResponseTest extends ModelBaseTest {

    private void verifyCorrectness(ErrorResponse sut) {
        assertThat(sut).isNotNull();
        assertThat(sut.getCode()).isNotNull().isEqualTo(code);
        assertThat(sut.getDescription()).isNotNull().isEqualTo(description);
        assertThat(sut.getParams()).isNotNull().isEqualTo(params);
    }

    @Test
    public void ValidPayload_CreatedBySetter() {
        verifyCorrectness(createErrorResponseBySetter());
    }

    @Test
    public void ValidPayload_CreatedByCode() {
        verifyCorrectness(createErrorResponseByConstructor());
    }
}
