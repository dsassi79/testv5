package com.fabrick.rest.testv5.models.responses;

import com.fabrick.rest.testv5.models.ModelBaseTest;
import com.fabrick.rest.testv5.models.response.GenericResponseWithGenericPayload;
import com.fabrick.rest.testv5.models.response.GetTransactionsResponse;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GeTransactionsResponseTest extends ModelBaseTest {

    private void verifyCorrectness(GetTransactionsResponse sut) {
        assertThat(sut).isNotNull();
        assertThat(sut.getStatus()).isNotNull().isEqualTo(status);
        assertThat(sut.getErrors()).isNotNull().hasSize(1);
        assertThat(sut.getErrors().get(0).getCode()).isNotNull().isEqualTo(code);
        assertThat(sut.getPayload()).isNotNull();
        assertThat(sut.getPayload().getList()).isNotNull().hasSize(1);
        assertThat(sut.getPayload().getList().get(0).getOperationId()).isNotNull().isEqualTo(operationId);
    }

    @Test
    public void ValidPayload_CreatedBySetter() {
        verifyCorrectness(createGetTransactionsResponseBySetter());
    }

    @Test
    public void ValidPayload_CreatedByCode() {
        verifyCorrectness(createGetTransactionsResponseByConstructor());
    }
}
