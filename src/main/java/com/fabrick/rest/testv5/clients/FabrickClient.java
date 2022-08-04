package com.fabrick.rest.testv5.clients;


import com.fabrick.rest.testv5.configurations.FeignConfig;
import com.fabrick.rest.testv5.exceptions.GenericException;
import com.fabrick.rest.testv5.models.request.MoneyTransferRequest;
import com.fabrick.rest.testv5.models.response.GetBalanceResponse;
import com.fabrick.rest.testv5.models.response.GetTransactionsResponse;
import com.fabrick.rest.testv5.models.response.MoneyTransferResponse;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@FeignClient(
        name = "fabrick",
        url = "${fabrick.url}",
        configuration = FeignConfig.class
)
public interface FabrickClient {

    @Headers({"Accept: " + MediaType.APPLICATION_JSON_VALUE, "Content-Type: " + MediaType.APPLICATION_JSON_VALUE})
    @PostMapping(value = "/{accountId}/payments/money-transfers")
    Optional<MoneyTransferResponse> postTransfer(
            @RequestHeader(value = "Api-Key") String apiKey,
            @RequestHeader(value = "Auth-Schema") String authSchema,
            @RequestHeader(value = "X-Time-Zone") String timeZone,
            @PathVariable("accountId") String accountId,
            @RequestBody MoneyTransferRequest moneyTransferRequest
    ) throws GenericException;

    @Headers({"Accept: " + MediaType.APPLICATION_JSON_VALUE})
    @GetMapping(value = "/{accountId}/balance")
    Optional<GetBalanceResponse> getBalance(
            @RequestHeader(value = "Api-Key") String apiKey,
            @RequestHeader(value = "Auth-Schema") String authSchema,
            @PathVariable("accountId") String accountId
    ) throws GenericException;

    @Headers({"Accept: " + MediaType.APPLICATION_JSON_VALUE})
    @GetMapping(value = "/{accountId}/transactions")
    Optional<GetTransactionsResponse> getTransactions(
            @RequestHeader(value = "Api-Key") String apiKey,
            @RequestHeader(value = "Auth-Schema") String authSchema,
            @PathVariable("accountId") String accountId,
            @RequestParam("fromAccountingDate") String fromAccountingDate,
            @RequestParam("toAccountingDate") String toAccountingDate
    ) throws GenericException;

}
