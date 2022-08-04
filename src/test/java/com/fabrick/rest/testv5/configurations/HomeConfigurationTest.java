package com.fabrick.rest.testv5.configurations;

import com.fabrick.rest.testv5.configurations.HomeConfiguration;
import com.fabrick.rest.testv5.models.ModelBaseTest;
import com.fabrick.rest.testv5.models.response.TransactionType;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HomeConfigurationTest extends ModelBaseTest {
    private void verifyCorrectness(HomeConfiguration sut) {
        assertThat(sut).isNotNull();
        assertThat(sut.getApikey()).isNotNull().isEqualTo(apiKey);
        assertThat(sut.getAuthSchema()).isNotNull().isEqualTo(authSchema);
        assertThat(sut.getTimeZone()).isNotNull().isEqualTo(timeZone);
        assertThat(sut.getFabrickUrl()).isNotNull().isEqualTo(fabrickUrl);

    }

    @Test
    public void ValidPayload_CreatedBySetter() {
        verifyCorrectness(createHomeConfigurationBySetter());
    }


}
