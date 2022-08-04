package com.fabrick.rest.testv5.controllers;

import com.fabrick.rest.testv5.exceptions.GenericError;
import com.fabrick.rest.testv5.exceptions.GenericException;
import com.fabrick.rest.testv5.models.request.MoneyTransferRequest;
import com.fabrick.rest.testv5.models.response.BalancePayload;
import com.fabrick.rest.testv5.models.response.MoneyTransferPayload;
import com.fabrick.rest.testv5.models.response.TransactionsPayload;
import com.fabrick.rest.testv5.services.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;

import static org.springframework.http.ResponseEntity.status;


@RestController
@RequestMapping("/api/v1/account")
@Slf4j
@Api(value = "/api/v1/account", produces = MediaType.APPLICATION_JSON_VALUE, tags = "Account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @ApiOperation(value = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "An object containing the balance", response = BalancePayload.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GenericError.class)
    })
    @GetMapping("/{accountId}/balance")
    public ResponseEntity<BalancePayload> getBalance(@PathVariable String accountId) throws GenericException {
        return status(HttpStatus.OK).body(accountService.getBalance(accountId));
    }

    @ApiOperation(value = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "An object containing the transactions", response = TransactionsPayload.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GenericError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GenericError.class)
    })


    @GetMapping("/{accountId}/transactions")
    public ResponseEntity<TransactionsPayload> getTransactions(@PathVariable String accountId, @RequestParam(required = false) String fromAccountingDate, @RequestParam(required = false) String toAccountingDate) throws GenericException {
        if (fromAccountingDate == null || fromAccountingDate.isEmpty()) {
            throw new GenericException("BS0001", "fromAccountingDate Parameter is missing");
        } else if (toAccountingDate == null || toAccountingDate.isEmpty()) {
            throw new GenericException("BS0011", "toAccountingDate Parameter is missing");
        } else {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            try {
                formatter.parse(fromAccountingDate);
            } catch (Exception ex) {
                throw new GenericException("BS0002", "fromAccountingDate Parameter not valid");
            }
            try {
                formatter.parse(toAccountingDate);
            } catch (Exception ex) {
                throw new GenericException("BS0012", "toAccountingDate Parameter not valid");
            }
            return status(HttpStatus.OK).body(accountService.getTransactions(accountId, fromAccountingDate, toAccountingDate));
        }
    }

    @ApiOperation(value = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Transfer confirmation", response = MoneyTransferPayload.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GenericError.class)
    })
    @PostMapping("/{accountId}/transfer")
    public ResponseEntity<MoneyTransferPayload> transferMoney(@PathVariable String accountId, @RequestBody(required = false) MoneyTransferRequest moneyTransfer) throws GenericException {
        if (moneyTransfer == null) {
            throw new GenericException("BS0021", "Request Body not valid");
        }
        return status(HttpStatus.OK).body(accountService.transferMoney(accountId, moneyTransfer));
    }

}
