package com.fabrick.rest.testv5.models.responses;

import com.fabrick.rest.testv5.models.ModelBaseTest;
import com.fabrick.rest.testv5.models.response.GenericResponseWithGenericPayload;
import com.fabrick.rest.testv5.models.response.GetBalanceResponse;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GetBalanceResponseTest extends ModelBaseTest {

    private void verifyCorrectness(GetBalanceResponse sut) {
        assertThat(sut).isNotNull();
        assertThat(sut.getStatus()).isNotNull().isEqualTo(status);
        assertThat(sut.getErrors()).isNotNull().hasSize(1);
        assertThat(sut.getErrors().get(0).getCode()).isNotNull().isEqualTo(code);
        assertThat(sut.getPayload()).isNotNull();
        assertThat(sut.getPayload().getCurrency()).isNotNull().isEqualTo(currency);
    }

    @Test
    public void ValidPayload_CreatedBySetter() {
        verifyCorrectness(createGetBalanceResponseBySetter());
    }

    @Test
    public void ValidPayload_CreatedByCode() {
        verifyCorrectness(createGetBalanceResponseByConstructor());
    }
}
