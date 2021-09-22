package com.kj.currencyconverter.services;

import com.kj.currencyconverter.bean.CurrencyConverterBean;
import com.kj.currencyconverter.services.clients.ExchangeRateClientInterface;

public class CurrencyConverterService {

    private ExchangeRateClientInterface exchangeRateClient;

    public CurrencyConverterService() {
    }

    /**
     * Constructor for CurrencyConverterService
     * it takes ExchangeRateClientInterface as param and any client that implements this interface
     * can be accepted. This way this class is open for extension
     *
     * @param
     */
    public CurrencyConverterService(ExchangeRateClientInterface exchangeRateClient) {
        this.exchangeRateClient = exchangeRateClient;
    }

    /**
     * The main method to convert taking the rates live
     * from the api
     *
     * @param from
     * @param to
     * @param quantity
     * @return CurrencyConverterBean
     */
    public CurrencyConverterBean convert(String from, String to, Double quantity){
       return this.exchangeRateClient.convert(from,to,quantity);
    }

    public ExchangeRateClientInterface getExchangeRateClient() {
        return exchangeRateClient;
    }

    public void setExchangeRateClient(ExchangeRateClientInterface exchangeRateClient) {
        this.exchangeRateClient = exchangeRateClient;
    }
}
