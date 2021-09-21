package com.kj.currencyconverter.services.clients;

import com.kj.currencyconverter.bean.CurrencyConverterBean;
import com.kj.currencyconverter.bean.CurrencyDTO;

public interface ExchangeRateClientInterface {

    public CurrencyConverterBean convert(String from, String to, Double quantity);

    public CurrencyDTO getRates();
}
