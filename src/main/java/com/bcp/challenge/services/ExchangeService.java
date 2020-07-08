package com.bcp.challenge.services;

import com.bcp.challenge.rest.request.ExchangeRateRequest;
import com.bcp.challenge.rest.response.ExchangeRateResponse;

public interface ExchangeService {

    ExchangeRateResponse convertCurrencies(ExchangeRateRequest exchangeRateRequest);

}
