package com.fabrick.rest.testv5.services;

import com.fabrick.rest.testv5.clients.FabrickClient;
import com.fabrick.rest.testv5.configurations.HomeConfiguration;
import com.fabrick.rest.testv5.exceptions.GenericException;
import com.fabrick.rest.testv5.models.ModelBaseTest;
import com.fabrick.rest.testv5.models.request.MoneyTransferRequest;
import com.fabrick.rest.testv5.models.response.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
public class AccountServiceTest extends ModelBaseTest {

    @Mock
    private HomeConfiguration homeConfiguration;
    @Mock
    private FabrickClient fabrickClient;
    @InjectMocks
    private AccountService accountService;

    public AccountServiceTest() throws Throwable {
    }

    @Before
    public void setup() throws GenericException {

        Optional<GetBalanceResponse> balanceResponse = Optional.of(createGetBalanceResponseByConstructor());
        Optional<GetTransactionsResponse> transactionsResponse = Optional.of(createGetTransactionsResponseByConstructor());
        Optional<MoneyTransferResponse> moneyTransferResponse = Optional.of(createMoneyTransferResponseByConstructor());
        //homeconfiguration
        given(homeConfiguration.getApikey()).willReturn(apiKey);
        given(homeConfiguration.getAuthSchema()).willReturn(authSchema);
        given(homeConfiguration.getTimeZone()).willReturn(timeZone);
        given(homeConfiguration.getFabrickUrl()).willReturn(fabrickUrl);
        //fabrickClient
        given(fabrickClient.getBalance(anyString(), anyString(), anyString())).willReturn(balanceResponse);
        given(fabrickClient.getTransactions(anyString(), anyString(), anyString(), anyString(), anyString())).willReturn(transactionsResponse);
        given(fabrickClient.postTransfer(anyString(), anyString(), anyString(), anyString(), any(MoneyTransferRequest.class))).willReturn(moneyTransferResponse);
    }

    @Test()
    public void getBalance_OK() throws GenericException {
        BalancePayload sut = accountService.getBalance(accountId);
        assertThat(sut).isNotNull();
        verifyCorrectnessBalancePayLoad(sut);

    }

    @Test()
    public void getTransactions_OK() throws GenericException {
        TransactionsPayload sut = accountService.getTransactions(accountId, fromAccountingDate, toAccountingDate);
        assertThat(sut).isNotNull();
        verityCorrectnessTransactionsPayload(sut);
    }

    @Test()
    public void postTransfer_OK() throws GenericException {
        MoneyTransferPayload sut = accountService.transferMoney(accountId, createMoneyTransferRequestByConstructor());
        assertThat(sut).isNotNull();
        verifyCorrectnessMoneyTransferPayload(sut);

    }

}
