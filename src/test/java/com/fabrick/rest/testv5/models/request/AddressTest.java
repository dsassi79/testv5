package com.fabrick.rest.testv5.models.request;

import com.fabrick.rest.testv5.models.ModelBaseTest;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AddressTest extends ModelBaseTest {

    private void verifyCorrectness(Address sut) {
        assertThat(sut).isNotNull();
        assertThat(sut.getAddress()).isNotNull().isEqualTo(address);
        assertThat(sut.getCity()).isNotNull().isEqualTo(city);
        assertThat(sut.getCountryCode()).isNotNull().isEqualTo(countryCode);
    }

    @Test
    public void ValidPayload_CreatedBySetter() {
        verifyCorrectness(createAddressBySetter());
    }

    @Test
    public void ValidPayload_CreatedByCode() {
        verifyCorrectness(createAddressByConstructor());
    }
}
