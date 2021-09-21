package com.kj.currencyconverter.services;

import com.kj.currencyconverter.bean.CurrencyConverterBean;
import com.kj.currencyconverter.services.clients.ExchangeRateClientInterface;
import org.springframework.stereotype.Service;

@Service
public class CurrencyConverterService {

    private ExchangeRateClientInterface exchangeRateClient;

    /**
     * Constructor for CurrencyConverterService
     * it takes ExchangeRateClientInterface as param and any client that implements this interface
     * can be accepted this way thic class is open for extension
     *
     * @param exchangeRateClient
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
     * @return
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
