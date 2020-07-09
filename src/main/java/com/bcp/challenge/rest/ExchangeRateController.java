package com.bcp.challenge.rest;

import com.bcp.challenge.dto.request.ExchangeRateRequest;
import com.bcp.challenge.dto.request.UpdateRateRequest;
import com.bcp.challenge.dto.response.ExchangeRateResponse;
import com.bcp.challenge.services.ExchangeService;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exchange-rates")
public class ExchangeRateController {

    private final ExchangeService exchangeService;

    @Autowired
    public ExchangeRateController(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    @PostMapping("/converter")
    @ResponseStatus(HttpStatus.OK)
    public Flowable<ExchangeRateResponse> convertCurrencies(@RequestBody ExchangeRateRequest exchangeRateRequest) {
        return this.exchangeService.convertCurrencies(exchangeRateRequest);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Completable updateExchangeRate(@RequestBody UpdateRateRequest updateRateRequest) {
        return this.exchangeService.updateExchangeRate(updateRateRequest);
    }

    @GetMapping("/currencies")
    @ResponseStatus(HttpStatus.OK)
    public Flowable<List<String>> getCurrencies() {
        return this.exchangeService.getCurrencies();
    }

}
