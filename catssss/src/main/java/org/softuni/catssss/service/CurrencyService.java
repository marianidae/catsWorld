package org.softuni.catssss.service;


import org.softuni.catssss.model.dto.ExchangeRatesDTO;

public interface CurrencyService {

    void refreshRates(ExchangeRatesDTO exchangeRatesDTO);


}
