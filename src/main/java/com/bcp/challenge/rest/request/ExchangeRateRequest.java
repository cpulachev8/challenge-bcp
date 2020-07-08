package com.bcp.challenge.rest.request;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ExchangeRateRequest {

    private BigDecimal amount;
    private Integer originCurrency;
    private Integer destinationCurrency;

}
