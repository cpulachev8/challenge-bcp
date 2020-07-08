package com.bcp.challenge.services;

import com.bcp.challenge.dto.request.ExchangeRateRequest;
import com.bcp.challenge.dto.request.UpdateRateRequest;
import com.bcp.challenge.dto.response.ExchangeRateResponse;
import io.reactivex.Completable;
import io.reactivex.Flowable;

public interface ExchangeService {

    Flowable<ExchangeRateResponse> convertCurrencies(ExchangeRateRequest exchangeRateRequest);

    Completable updateExchangeRate(UpdateRateRequest updateRateRequest);

}
