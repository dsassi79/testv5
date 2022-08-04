package com.fabrick.rest.testv5.models.responses;

import com.fabrick.rest.testv5.models.ModelBaseTest;
import com.fabrick.rest.testv5.models.response.BalancePayload;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BalancePayloadTest extends ModelBaseTest {


    @Test
    public void ValidPayload_CreatedBySetter() {
        verifyCorrectnessBalancePayLoad(createBalancePayloadBySetter());
    }

    @Test
    public void ValidPayload_CreatedByCode() {
        verifyCorrectnessBalancePayLoad(createBalancePayloadByConstructor());
    }
}

