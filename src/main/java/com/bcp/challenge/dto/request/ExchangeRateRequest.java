package com.bcp.challenge.dto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ExchangeRateRequest {

    private BigDecimal amount;
    private String originCurrency;
    private String destinationCurrency;

}
