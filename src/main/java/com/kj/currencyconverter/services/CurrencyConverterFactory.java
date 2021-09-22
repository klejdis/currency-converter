package com.kj.currencyconverter.services;

import com.kj.currencyconverter.services.clients.ExchangeRateClientInterface;
import com.kj.currencyconverter.services.clients.ExchangeRatesApiClient;
import com.kj.currencyconverter.services.clients.FixerApiClient;
import com.kj.currencyconverter.services.exceptions.RateProviderNotSupportedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class CurrencyConverterFactory {

    private CurrencyConverterService currencyConverterService;
    private ExchangeRateClientInterface exchangeRatesApiClient;

    @Autowired
    public Environment env;

    public CurrencyConverterService getService() throws Exception {

        String provider =  env.getProperty("spring.rates.provider");

        if (provider.equals("fixer")){
            exchangeRatesApiClient = new FixerApiClient(env.getProperty("spring.rates.provider.fixer"));
        }else if(provider.equals("exchangerates")){
            exchangeRatesApiClient = new ExchangeRatesApiClient(env.getProperty("spring.rates.provider.exchangerates"));
        }else{
            throw new RateProviderNotSupportedException("Rate Provider "+ provider +" Not Supported");
        }

        this.currencyConverterService = new CurrencyConverterService(exchangeRatesApiClient);

        return this.currencyConverterService;
    }

}
