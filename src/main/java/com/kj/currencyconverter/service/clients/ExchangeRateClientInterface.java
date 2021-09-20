package com.kj.currencyconverter.service.clients;

import com.kj.currencyconverter.bean.CurrencyConverterBean;

import java.math.BigDecimal;

public interface ExchangeRateClientInterface {

    public CurrencyConverterBean convert(String from, String to, Double quantity);
}
