package com.bcp.challenge.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeRateResponse {

        private BigDecimal amount;
        private BigDecimal amountWithExchangeRate;
        private String originCurrency;
        private String destinationCurrency;
        private BigDecimal exchangeRate;

}
