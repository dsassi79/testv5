package com.fabrick.rest.testv5.services;


import com.fabrick.rest.testv5.clients.FabrickClient;
import com.fabrick.rest.testv5.configurations.HomeConfiguration;
import com.fabrick.rest.testv5.exceptions.GenericException;
import com.fabrick.rest.testv5.models.request.MoneyTransferRequest;
import com.fabrick.rest.testv5.models.response.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class AccountService {
    @Lazy
    @Autowired
    FabrickClient fabrickClient;

    @Autowired
    HomeConfiguration homeConfiguration;

    public BalancePayload getBalance(String accountId) throws GenericException {
        Optional<GetBalanceResponse> response = fabrickClient.getBalance(homeConfiguration.getApikey(), homeConfiguration.getAuthSchema(), accountId);
        return response.get().getPayload();
    }

    public TransactionsPayload getTransactions(String accountId, String fromAccountingDate, String toAccountingDate) throws GenericException {
        Optional<GetTransactionsResponse> response = fabrickClient.getTransactions(homeConfiguration.getApikey(), homeConfiguration.getAuthSchema(), accountId, fromAccountingDate, toAccountingDate);
        return response.get().getPayload();
    }

    public MoneyTransferPayload transferMoney(String accountId, MoneyTransferRequest request) throws GenericException {
        Optional<MoneyTransferResponse> response = fabrickClient.postTransfer(homeConfiguration.getApikey(), homeConfiguration.getAuthSchema(), homeConfiguration.getTimeZone(), accountId, request);
        return (response.get().getPayload());
    }

}
