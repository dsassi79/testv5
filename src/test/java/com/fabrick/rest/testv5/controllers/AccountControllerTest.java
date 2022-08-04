package com.fabrick.rest.testv5.controllers;

import com.fabrick.rest.testv5.exceptions.GenericException;
import com.fabrick.rest.testv5.models.ModelBaseTest;
import com.fabrick.rest.testv5.models.request.MoneyTransferRequest;
import com.fabrick.rest.testv5.models.response.BalancePayload;
import com.fabrick.rest.testv5.models.response.MoneyTransferPayload;
import com.fabrick.rest.testv5.models.response.TransactionsPayload;
import com.fabrick.rest.testv5.services.AccountService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class AccountControllerTest extends ModelBaseTest {
    @Autowired
    private AccountController accountController;
    @MockBean
    private AccountService accountService;

    private static final String path = "mock/";

    @Test
    public void GetBalance_OK() throws GenericException {
        //given
        Mockito.when(accountService.getBalance(any(String.class))).thenReturn(createBalancePayloadByConstructor());
        //when
        ResponseEntity<BalancePayload> sut = accountController.getBalance(accountId);
        //then
        assertThat(sut).isNotNull();
        assertThat(sut.getStatusCode()).isNotNull().isEqualTo(HttpStatus.OK);
        assertThat(sut.getBody()).isNotNull();
        verifyCorrectnessBalancePayLoad(sut.getBody());
    }


    @Test
    public void GetTransaction_OK() throws GenericException {

        //given
        Mockito.when(accountService.getTransactions(any(String.class), any(String.class), any(String.class))).thenReturn(createTransactionsPayloadBySetter());
        //when
        ResponseEntity<TransactionsPayload> sut = accountController.getTransactions(accountId, fromAccountingDate, toAccountingDate);
        //then
        assertThat(sut).isNotNull();
        assertThat(sut.getStatusCode()).isNotNull().isEqualTo(HttpStatus.OK);
        assertThat(sut.getBody()).isNotNull();
        verityCorrectnessTransactionsPayload(sut.getBody());
    }

    @Test(expected = GenericException.class)
    public void GetTransaction_WNullFromDate_KO() throws GenericException {
        //given
        Mockito.when(accountService.getTransactions(any(String.class), any(String.class), any(String.class))).thenReturn(createTransactionsPayloadBySetter());
        //when
        ResponseEntity<TransactionsPayload> sut = accountController.getTransactions(accountId, null, toAccountingDate);
        //then
        assertThat(sut).isNotNull();
        assertThat(sut.getStatusCode()).isNotNull().isEqualTo(HttpStatus.OK);
        assertThat(sut.getBody()).isNotNull();
        verityCorrectnessTransactionsPayload(sut.getBody());
    }

    @Test(expected = GenericException.class)
    public void GetTransaction_WNullToDate_KO() throws GenericException {
        //given
        Mockito.when(accountService.getTransactions(any(String.class), any(String.class), any(String.class))).thenReturn(createTransactionsPayloadBySetter());
        //when
        ResponseEntity<TransactionsPayload> sut = accountController.getTransactions(accountId, fromAccountingDate, null);
        //then
        assertThat(sut).isNotNull();
        assertThat(sut.getStatusCode()).isNotNull().isEqualTo(HttpStatus.OK);
        assertThat(sut.getBody()).isNotNull();
        verityCorrectnessTransactionsPayload(sut.getBody());
    }

    @Test(expected = GenericException.class)
    public void GetTransaction_WWrongFromDate_KO() throws GenericException {
        //given
        Mockito.when(accountService.getTransactions(any(String.class), any(String.class), any(String.class))).thenReturn(createTransactionsPayloadBySetter());
        //when
        ResponseEntity<TransactionsPayload> sut = accountController.getTransactions(accountId, "XXXXX", toAccountingDate);
        //then
        assertThat(sut).isNotNull();
        assertThat(sut.getStatusCode()).isNotNull().isEqualTo(HttpStatus.OK);
        assertThat(sut.getBody()).isNotNull();
        verityCorrectnessTransactionsPayload(sut.getBody());
    }

    @Test(expected = GenericException.class)
    public void GetTransaction_WWrongToDate_KO() throws GenericException {
        //given
        Mockito.when(accountService.getTransactions(any(String.class), any(String.class), any(String.class))).thenReturn(createTransactionsPayloadBySetter());
        //when
        ResponseEntity<TransactionsPayload> sut = accountController.getTransactions(accountId, fromAccountingDate, "XXXXX");
        //then
        assertThat(sut).isNotNull();
        assertThat(sut.getStatusCode()).isNotNull().isEqualTo(HttpStatus.OK);
        assertThat(sut.getBody()).isNotNull();
        verityCorrectnessTransactionsPayload(sut.getBody());
    }


    @Test
    public void PostTransferMoney_OK() throws GenericException {
        //given
        Mockito.when(accountService.transferMoney(any(String.class), any(MoneyTransferRequest.class))).thenReturn(createMoneyTransferPayloadByConstructor());
        //when
        ResponseEntity<MoneyTransferPayload> sut = accountController.transferMoney(accountId, createMoneyTransferRequestByConstructor());
        //then
        assertThat(sut).isNotNull();
        assertThat(sut.getStatusCode()).isNotNull().isEqualTo(HttpStatus.OK);
        assertThat(sut.getBody()).isNotNull();
        verifyCorrectnessMoneyTransferPayload(sut.getBody());
    }

    @Test(expected = GenericException.class)
    public void PostTransferMoney_NullBody_KO() throws GenericException {
        //given
        Mockito.when(accountService.transferMoney(any(String.class), any(MoneyTransferRequest.class))).thenReturn(createMoneyTransferPayloadByConstructor());
        //when
        ResponseEntity<MoneyTransferPayload> sut = accountController.transferMoney(accountId, null);
        //then
        assertThat(sut).isNotNull();
        assertThat(sut.getStatusCode()).isNotNull().isEqualTo(HttpStatus.OK);
        assertThat(sut.getBody()).isNotNull();
        verifyCorrectnessMoneyTransferPayload(sut.getBody());
    }


}