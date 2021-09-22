package com.kj.currencyconverter.services.currencyconverter;

import com.kj.currencyconverter.repositories.CurrencyRepository;
import com.kj.currencyconverter.services.currencyconverter.clients.ExchangeRateClientInterface;
import com.kj.currencyconverter.services.currencyconverter.clients.ExchangeRatesApiClient;
import com.kj.currencyconverter.services.currencyconverter.clients.FixerApiClient;
import com.kj.currencyconverter.services.currencyconverter.exceptions.RateProviderNotSupportedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class CurrencyConverterFactory {

    private CurrencyConverterService currencyConverterService;
    private ExchangeRateClientInterface exchangeRatesApiClient;

    @Autowired
    public Environment env;

    @Autowired
    private CurrencyRepository currencyRepository;

    public CurrencyConverterService getService() throws Exception {

        String provider =  env.getProperty("spring.rates.provider");

        if (provider.equals("fixer")){
            exchangeRatesApiClient = new FixerApiClient(env.getProperty("spring.rates.provider.fixer"));
        }else if(provider.equals("exchangerates")){
            exchangeRatesApiClient = new ExchangeRatesApiClient(env.getProperty("spring.rates.provider.exchangerates"));
        }else{
            throw new RateProviderNotSupportedException("Rate Provider "+ provider +" Not Supported");
        }

        this.currencyConverterService = new CurrencyConverterService(exchangeRatesApiClient, currencyRepository);

        return this.currencyConverterService;
    }

}
