package com.fabrick.rest.testv5.models.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class TransactionsPayload {
    List<Transaction> list;

}
