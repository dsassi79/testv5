package com.fabrick.rest.testv5.models.responses;

import com.fabrick.rest.testv5.models.ModelBaseTest;
import com.fabrick.rest.testv5.models.response.BalancePayload;
import com.fabrick.rest.testv5.models.response.MoneyTransferPayload;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTransferPayloadTest extends ModelBaseTest {


    @Test
    public void ValidPayload_CreatedBySetter() {
        verifyCorrectnessMoneyTransferPayload(createMoneyTransferPayloadBySetter());
    }

    @Test
    public void ValidPayload_CreatedByCode() {
        verifyCorrectnessMoneyTransferPayload(createMoneyTransferPayloadByConstructor());
    }
}

