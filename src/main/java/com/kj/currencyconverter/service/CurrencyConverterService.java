package com.kj.currencyconverter.service;

import com.kj.currencyconverter.bean.CurrencyConverterBean;
import com.kj.currencyconverter.service.clients.ExchangeRateClientInterface;

public class CurrencyConverterService {

    private ExchangeRateClientInterface exchangeRateClient;

    public CurrencyConverterService(ExchangeRateClientInterface exchangeRateClient) {
        this.exchangeRateClient = exchangeRateClient;
    }


    public CurrencyConverterBean convert(String from, String to, Double quantity){


       return this.exchangeRateClient.convert(from,to,quantity);
    }

}
