package com.kj.currencyconverter.services;

import com.kj.currencyconverter.services.clients.ExchangeRatesApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyConverterFactory {

    @Autowired
    private ExchangeRatesApiClient exchangeRatesApiClient;

    public CurrencyConverterService getService(){
        return new CurrencyConverterService(exchangeRatesApiClient);
    }
}
