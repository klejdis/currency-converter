package com.kj.currencyconverter.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class CurrencyConverterService {

    private ExchangeRateClientInterface exchangeRateClient;

    public CurrencyConverterService(ExchangeRateClientInterface exchangeRateClient) {
        this.exchangeRateClient = exchangeRateClient;
    }


    public String convert(){

        ResponseEntity<ExchangeRateApiResponseBean> responseEntity = null;

        responseEntity = new RestTemplate().getForEntity("http://api.exchangeratesapi.io/v1/latest?access_key=dfb6f1954e9b9fdc285f4251475fc90b",
                ExchangeRateApiResponseBean.class);


       return this.exchangeRateClient.convert();
    }

}
