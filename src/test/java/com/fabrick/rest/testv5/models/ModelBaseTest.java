package com.fabrick.rest.testv5.models;

import com.fabrick.rest.testv5.configurations.HomeConfiguration;
import com.fabrick.rest.testv5.exceptions.GenericError;
import com.fabrick.rest.testv5.exceptions.GenericException;
import com.fabrick.rest.testv5.models.request.*;
import com.fabrick.rest.testv5.models.response.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ModelBaseTest {

    protected static final String accountCode = "IT12345678";
    protected static final String bicCode = "SELBIT2BXXX";
    protected static final String address = "Via Foscolo";
    protected static final String countryCode = "IT";
    protected static final String city = "Milano";
    protected static final String name = "Daniel";
    protected static final String fiscalCode = "YYYYYY";
    protected static final String fiscalCode1 = "AAAAAA";
    protected static final String fiscalCode2 = "BBBBBB";
    protected static final String fiscalCode3 = "CCCCCC";
    protected static final String fiscalCode4 = "DDDDDD";
    protected static final String fiscalCode5 = "EEEEEE";
    protected static final String legalRepresentativeFiscalCode = "XXXXXX";
    protected static final String taxReliefId = "TR001";
    protected static final boolean isCondoUpgrade = true;
    protected static final String creditorFiscalCode = "FFFFFF";
    protected static final String beneficiaryType = "1";
    protected static final String executionDate = "2022-01-01";
    protected static final String uri = "URI";
    protected static final String description = "description";
    protected static final Float amount = 0.88f;
    protected static final String currency = "EUR";
    protected static final boolean isUrgent = false;
    protected static final boolean isInstant = true;
    protected static final String feeType = "AAA";
    protected static final String feeAccountId = "23456";
    protected static final String code = "API000";
    protected static final String params = "Params";


    protected static final String transactionId = "1888";
    protected static final String operationId = "1999";
    protected static final String accountingDate = "2023-01-05";
    protected static final String valueDate = "2022-01-05";


    protected static final String enumeration = "GBS_TRANSACTION_TYPE";
    protected static final String value = "GBS_ACCOUNT_TRANSACTION_TYPE_0009";
    protected static final String status = "1";


    protected static final String date = "2022-11-11";
    protected static final Float balance = 0.4f;
    protected static final Float availableBalance = 0.3f;

    protected static final String statusMT = "EXECUTED";

    protected static final String accountId = "1234567";

    protected static final String apiKey = "KEY";
    protected static final String authSchema = "S2S";
    protected static final String timeZone = "Europe/Rome";
    protected static final String fabrickUrl = "url";

    protected static final String fromAccountingDate = "2020-01-01";
    protected static final String toAccountingDate = "2020-12-31";


    //region "Account"
    public Account createAccountByConstructor() {
        return new Account(accountCode, bicCode);
    }

    ;

    public Account createAccountBySetter() {
        Account sut = new Account();
        sut.setAccountCode(accountCode);
        sut.setBicCode(bicCode);
        return sut;
    }

    ;
    //endregion

    //region "Address"
    public Address createAddressByConstructor() {
        return new Address(address, city, countryCode);
    }

    ;

    public Address createAddressBySetter() {
        Address sut = new Address();
        sut.setAddress(address);
        sut.setCity(city);
        sut.setCountryCode(countryCode);
        return sut;
    }

    ;
    //endregion

    //region "Creditor"
    public Creditor createCreditorByConstructor() {
        return new Creditor(name, createAccountByConstructor(), createAddressByConstructor());
    }

    ;

    public Creditor createCreditorBySetter() {
        Creditor sut = new Creditor();
        sut.setName(name);
        sut.setAccount(createAccountBySetter());
        sut.setAddress(createAddressBySetter());
        return sut;
    }

    ;
    //endregion

    //region "LegalPersonBeneficiary"
    public LegalPersonBeneficiary createLegalPersonBeneficiaryByConstructor() {
        return new LegalPersonBeneficiary(fiscalCode, legalRepresentativeFiscalCode);
    }

    ;

    public LegalPersonBeneficiary createLegalPersonBeneficiaryBySetter() {
        LegalPersonBeneficiary sut = new LegalPersonBeneficiary();
        sut.setFiscalCode(fiscalCode);
        sut.setLegalRepresentativeFiscalCode(legalRepresentativeFiscalCode);
        return sut;
    }

    ;
    //endregion

    //region "NaturalPersonBeneficiary"
    public NaturalPersonBeneficiary createNaturalPersonBeneficiaryByConstructor() {
        return new NaturalPersonBeneficiary(fiscalCode1, fiscalCode2, fiscalCode3, fiscalCode4, fiscalCode5);
    }

    ;

    public NaturalPersonBeneficiary createNaturalPersonBeneficiaryBySetter() {
        NaturalPersonBeneficiary sut = new NaturalPersonBeneficiary();
        sut.setFiscalCode1(fiscalCode1);
        sut.setFiscalCode2(fiscalCode2);
        sut.setFiscalCode3(fiscalCode3);
        sut.setFiscalCode4(fiscalCode4);
        sut.setFiscalCode5(fiscalCode5);
        return sut;
    }
    //endregion

    //region "TaxRelief"
    public TaxRelief createTaxReliefByConstructor() {
        return new TaxRelief(taxReliefId, isCondoUpgrade, creditorFiscalCode, beneficiaryType, createNaturalPersonBeneficiaryByConstructor(), createLegalPersonBeneficiaryByConstructor());
    }

    public TaxRelief createTaxReliefBySetter() {
        TaxRelief sut = new TaxRelief();
        sut.setTaxReliefId(taxReliefId);
        sut.setBeneficiaryType(beneficiaryType);
        sut.setCondoUpgrade(isCondoUpgrade);
        sut.setCreditorFiscalCode(creditorFiscalCode);
        sut.setNaturalPersonBeneficiary(createNaturalPersonBeneficiaryBySetter());
        sut.setLegalPersonBeneficiary(createLegalPersonBeneficiaryBySetter());
        return sut;
    }
    //endregion

    //region "MoneyTransferRequest"
    public MoneyTransferRequest createMoneyTransferRequestByConstructor() {
        return new MoneyTransferRequest(createCreditorByConstructor(), executionDate, uri, description, amount, currency, isUrgent, isInstant, feeType, feeAccountId, createTaxReliefByConstructor());
    }

    public MoneyTransferRequest createMoneyTransferRequestBySetter() {
        MoneyTransferRequest sut = new MoneyTransferRequest();
        sut.setAmount(amount);
        sut.setCreditor(createCreditorBySetter());
        sut.setCurrency(currency);
        sut.setDescription(description);
        sut.setExecutionDate(executionDate);
        sut.setUri(uri);
        sut.setUrgent(isUrgent);
        sut.setInstant(isInstant);
        sut.setTaxRelief(createTaxReliefBySetter());
        sut.setFeeAccountId(feeAccountId);
        sut.setFeeType(feeType);
        return sut;
    }
    //endregion

    //region "ErrorResponse"
    public ErrorResponse createErrorResponseByConstructor() {
        return new ErrorResponse(code, description, params);
    }

    public ErrorResponse createErrorResponseBySetter() {
        ErrorResponse sut = new ErrorResponse();
        sut.setCode(code);
        sut.setDescription(description);
        sut.setParams(params);

        return sut;
    }
    //endregion

    //region "ErrorsResponse"


    public ErrorsResponse createErrorsResponseBySetter() {
        ErrorsResponse sut = new ErrorsResponse();
        sut.add(createErrorResponseBySetter());
        return sut;
    }
    //endregion

    //region "TransactionType"
    public TransactionType createTransactionTypeByConstructor() {
        return new TransactionType(enumeration, value);
    }

    public TransactionType createTransactionTypeBySetter() {
        TransactionType sut = new TransactionType();
        sut.setEnumeration(enumeration);
        sut.setValue(value);
        return sut;
    }
    //endregion

    //region "Transaction"
    public Transaction createTransactionByConstructor() {
        return new Transaction(transactionId, operationId, accountingDate,
                valueDate, createTransactionTypeByConstructor(), amount, currency, description);
    }

    public Transaction createTransactionBySetter() {
        Transaction sut = new Transaction();
        sut.setTransactionId(transactionId);
        sut.setOperationId(operationId);
        sut.setAccountingDate(accountingDate);
        sut.setValueDate(valueDate);
        sut.setType(createTransactionTypeBySetter());
        sut.setAmount(amount);
        sut.setCurrency(currency);
        sut.setDescription(description);
        return sut;
    }
    //endregion


    //region "GenericResponse"
    public GenericResponse createGenericResponseByConstructor() {
        return new GenericResponse(status, createErrorsResponseBySetter());
    }

    public GenericResponse createGenericResponseBySetter() {
        GenericResponse sut = new GenericResponse();
        sut.setStatus(status);
        sut.setErrors(createErrorsResponseBySetter());
        return sut;
    }
    //endregion

    //region "GenericResponseWithGenericPayload"
    public GenericResponseWithGenericPayload createGenericResponseWithGenericPayloadByConstructor() {
        return new GenericResponseWithGenericPayload(status, createErrorsResponseBySetter(), new Object());
    }

    public GenericResponseWithGenericPayload createGenericResponseWithGenericPayloadBySetter() {
        GenericResponseWithGenericPayload sut = new GenericResponseWithGenericPayload();
        sut.setStatus(status);
        sut.setErrors(createErrorsResponseBySetter());
        sut.setPayload(new Object());
        return sut;
    }
    //endregion

    //region "TransactionsPayload"


    public TransactionsPayload createTransactionsPayloadBySetter() {
        TransactionsPayload sut = new TransactionsPayload();
        sut.setList(Collections.singletonList(createTransactionBySetter()));
        return sut;
    }
    //endregion

    //region "GetBalanceResponse"
    public GetBalanceResponse createGetBalanceResponseByConstructor() {
        return new GetBalanceResponse(status, createErrorsResponseBySetter(), createBalancePayloadByConstructor());
    }

    public GetBalanceResponse createGetBalanceResponseBySetter() {
        GetBalanceResponse sut = new GetBalanceResponse();
        sut.setStatus(status);
        sut.setErrors(createErrorsResponseBySetter());
        sut.setPayload(createBalancePayloadBySetter());
        return sut;
    }
    //endregion

    //region "GetTransactionsResponse"
    public GetTransactionsResponse createGetTransactionsResponseByConstructor() {
        return new GetTransactionsResponse(status, createErrorsResponseBySetter(), createTransactionsPayloadBySetter());
    }

    public GetTransactionsResponse createGetTransactionsResponseBySetter() {
        GetTransactionsResponse sut = new GetTransactionsResponse();
        sut.setStatus(status);
        sut.setErrors(createErrorsResponseBySetter());
        sut.setPayload(createTransactionsPayloadBySetter());
        return sut;
    }
    //endregion

    //region "MoneyTransferResponse"
    public MoneyTransferResponse createMoneyTransferResponseByConstructor() {
        return new MoneyTransferResponse(status, createErrorsResponseBySetter(), createMoneyTransferPayloadByConstructor());
    }

    public MoneyTransferResponse createMoneyTransferResponseBySetter() {
        MoneyTransferResponse sut = new MoneyTransferResponse();
        sut.setStatus(status);
        sut.setErrors(createErrorsResponseBySetter());
        sut.setPayload(createMoneyTransferPayloadBySetter());
        return sut;
    }
    //endregion

    //region "BalancePayload"
    public BalancePayload createBalancePayloadByConstructor() {
        return new BalancePayload(date, balance, availableBalance, currency);
    }

    public BalancePayload createBalancePayloadBySetter() {
        BalancePayload sut = new BalancePayload();
        sut.setDate(date);
        sut.setBalance(balance);
        sut.setAvailableBalance(availableBalance);
        sut.setCurrency(currency);
        return sut;
    }
    //endregion

    //region "MoneyTransferPayload"
    public MoneyTransferPayload createMoneyTransferPayloadByConstructor() {
        return new MoneyTransferPayload(statusMT);
    }

    public MoneyTransferPayload createMoneyTransferPayloadBySetter() {
        MoneyTransferPayload sut = new MoneyTransferPayload();
        sut.setStatus(statusMT);

        return sut;
    }
    //endregion

    //region "GenericError"
    public GenericError createGenericErrorByConstructor() {
        return new GenericError(code, description);
    }

    public GenericError createGenericErrorBySetter() {
        GenericError sut = new GenericError();
        sut.setCode(code);
        sut.setDescription(description);
        return sut;
    }
    //endregion

    //region "GenericError"
    public GenericException createGenericExceptionByConstructor() {
        return new GenericException(code, description);
    }

    public GenericException createGenericExceptionBySetter() {
        GenericException sut = new GenericException();
        sut.setCode(code);
        sut.setMessage(description);
        return sut;
    }
    //endregion

    public HomeConfiguration createHomeConfigurationBySetter() {
        HomeConfiguration sut = new HomeConfiguration();
        sut.setApikey(apiKey);
        sut.setAuthSchema(authSchema);
        sut.setFabrickUrl(fabrickUrl);
        sut.setTimeZone(timeZone);
        return sut;
    }


    protected void verifyCorrectnessBalancePayLoad(BalancePayload sut) {
        assertThat(sut).isNotNull();
        assertThat(sut.getDate()).isNotNull().isEqualTo(date);
        assertThat(sut.getAvailableBalance()).isNotNull().isEqualTo(availableBalance);
        assertThat(sut.getBalance()).isNotNull().isEqualTo(balance);
        assertThat(sut.getCurrency()).isNotNull().isEqualTo(currency);
    }

    protected void verifyCorrectnessMoneyTransferPayload(MoneyTransferPayload sut) {
        assertThat(sut).isNotNull();
        assertThat(sut.getStatus()).isEqualTo(statusMT);

    }

    protected void verityCorrectnessTransactionsPayload(TransactionsPayload sut) {
        assertThat(sut).isNotNull();
        assertThat(sut.getList()).isNotNull().hasSize(1);
        assertThat(sut.getList().get(0).getOperationId()).isNotNull().isEqualTo(operationId);
        //fatto check solo su una proprietà perchè già coperta nel test model e per questioni di tempo
    }


    @Test
    public void emptyTest() {
    }

}
