package com.kj.currencyconverter.services;

import com.kj.currencyconverter.bean.CurrencyConverterBean;
import com.kj.currencyconverter.services.clients.ExchangeRateClientInterface;
import org.springframework.stereotype.Service;

@Service
public class CurrencyConverterService {

    private ExchangeRateClientInterface exchangeRateClient;

    public CurrencyConverterService(ExchangeRateClientInterface exchangeRateClient) {
        this.exchangeRateClient = exchangeRateClient;
    }


    public CurrencyConverterBean convert(String from, String to, Double quantity){


       return this.exchangeRateClient.convert(from,to,quantity);
    }

}
