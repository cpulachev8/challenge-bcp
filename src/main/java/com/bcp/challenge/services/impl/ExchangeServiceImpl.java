package com.bcp.challenge.services.impl;

import com.bcp.challenge.dto.request.UpdateRateRequest;
import com.bcp.challenge.model.ExchangeRate;
import com.bcp.challenge.repository.ExchangeRateRepository;
import com.bcp.challenge.dto.request.ExchangeRateRequest;
import com.bcp.challenge.dto.response.ExchangeRateResponse;
import com.bcp.challenge.services.ExchangeService;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ExchangeServiceImpl implements ExchangeService {

    private final ExchangeRateRepository exchangeRateRepository;

    @Autowired
    public ExchangeServiceImpl(ExchangeRateRepository exchangeRateRepository) {
        this.exchangeRateRepository = exchangeRateRepository;
    }

    @Override
    public Flowable<ExchangeRateResponse> convertCurrencies(ExchangeRateRequest exchangeRateRequest) {
        return Flowable.just(exchangeRateRequest)
                .flatMap(err -> Flowable.just(applyExchangeRate(err)));
    }

    @Override
    public Completable updateExchangeRate(UpdateRateRequest updateRateRequest) {
        return Flowable.just(this.exchangeRateRepository
                .findByOriginCurrencyAndDestinationCurrency(updateRateRequest.getOriginCurrency(), updateRateRequest.getDestinationCurrency())
                .orElse(null)
            ).flatMapCompletable(exchangeRate -> Completable.fromRunnable(() -> {
                exchangeRate.setRate(updateRateRequest.getRate());
                this.exchangeRateRepository.save(exchangeRate);
        }));
    }

    public ExchangeRateResponse applyExchangeRate(ExchangeRateRequest exchangeRateRequest) {
        ExchangeRate rate = this.exchangeRateRepository.findByOriginCurrencyAndDestinationCurrency(exchangeRateRequest.getOriginCurrency(), exchangeRateRequest.getDestinationCurrency())
                .orElse(ExchangeRate.builder().rate(BigDecimal.ZERO).build());
        return ExchangeRateResponse.builder()
                .amount(exchangeRateRequest.getAmount())
                .amountWithExchangeRate(exchangeRateRequest.getAmount().multiply(rate.getRate()))
                .originCurrency(rate.getOriginCurrency())
                .destinationCurrency(rate.getDestinationCurrency())
                .exchangeRate(rate.getRate())
                .build();
    }
}
