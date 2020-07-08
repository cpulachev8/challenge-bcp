package com.bcp.challenge.repository;

import com.bcp.challenge.model.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {

    Optional<ExchangeRate> findByOriginCurrencyAndDestinationCurrency(String originCurrency, String destinationCurrency);
}
