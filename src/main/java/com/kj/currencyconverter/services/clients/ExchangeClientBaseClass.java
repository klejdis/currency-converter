package com.kj.currencyconverter.services.clients;

import com.kj.currencyconverter.bean.CurrencyConverterBean;
import com.kj.currencyconverter.bean.CurrencyDTO;

public class ExchangeClientBaseClass implements ExchangeRateClientInterface {

    protected String uri;

    public ExchangeClientBaseClass(String uri) {
        this.uri = uri;
    }

    @Override
    public CurrencyConverterBean convert(String from, String to, Double quantity) {
        return null;
    }

    @Override
    public CurrencyDTO getRates() {
        return null;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
