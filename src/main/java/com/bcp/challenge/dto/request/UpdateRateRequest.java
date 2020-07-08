package com.bcp.challenge.dto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UpdateRateRequest {

    private String originCurrency;
    private String destinationCurrency;
    private BigDecimal rate;

}
