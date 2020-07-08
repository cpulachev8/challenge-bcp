package com.bcp.challenge.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "exchange_rate")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExchangeRate {

    @Id
    private Long id;

    @Column(name = "origin_currency")
    private String originCurrency;

    @Column(name = "destination_currency")
    private String destinationCurrency;

    @Column(name = "rate")
    private BigDecimal rate;

}
