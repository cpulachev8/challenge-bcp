package com.bcp.challenge.rest;

import com.bcp.challenge.rest.request.ExchangeRateRequest;
import com.bcp.challenge.rest.response.ExchangeRateResponse;
import com.bcp.challenge.services.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/exchange-rates")
public class ExchangeRateController {

    private final ExchangeService exchangeService;

    @Autowired
    public ExchangeRateController(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ExchangeRateResponse convertCurrencies(@RequestBody ExchangeRateRequest exchangeRateRequest) {
        return this.exchangeService.convertCurrencies(exchangeRateRequest);
    }
}
