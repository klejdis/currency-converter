package com.kj.currencyconverter.services.clients;

import com.kj.currencyconverter.bean.CurrencyConverterBean;

public interface ExchangeRateClientInterface {

    public CurrencyConverterBean convert(String from, String to, Double quantity);
}
