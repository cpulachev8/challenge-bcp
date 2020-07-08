package com.bcp.challenge.services.impl;

import com.bcp.challenge.rest.request.ExchangeRateRequest;
import com.bcp.challenge.rest.response.ExchangeRateResponse;
import com.bcp.challenge.services.ExchangeService;
import org.springframework.stereotype.Service;
import rx.Observable;

import java.math.BigDecimal;

@Service
public class ExchangeServiceImpl implements ExchangeService {

    ExchangeRateResponse exchangeRateResponse;

    @Override
    public ExchangeRateResponse convertCurrencies(ExchangeRateRequest exchangeRateRequest) {
        Observable<ExchangeRateRequest> observer = Observable.just(exchangeRateRequest);
        observer.map(err -> applyExchangeRate(err))
                .subscribe(err -> {
                    exchangeRateResponse = ExchangeRateResponse.builder()
                            .amount(exchangeRateRequest.getAmount())
                            .amountWithExchangeRate(err)
                            .originCurrency("SOLES")
                            .destinationCurrency("DOLARES")
                            .exchangeRate(new BigDecimal("3.14"))
                            .build();
                }
        );
        return exchangeRateResponse;
    }

    public BigDecimal applyExchangeRate(ExchangeRateRequest exchangeRateRequest) {
        return exchangeRateRequest.getAmount().multiply(new BigDecimal("3.14"));
    }
}
