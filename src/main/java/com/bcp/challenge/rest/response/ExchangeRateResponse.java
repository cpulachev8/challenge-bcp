package com.bcp.challenge.rest.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ExchangeRateResponse {

    private BigDecimal amount;
    private BigDecimal amountWithExchangeRate;
    private String originCurrency;
    private String destinationCurrency;
    private BigDecimal exchangeRate;

}
