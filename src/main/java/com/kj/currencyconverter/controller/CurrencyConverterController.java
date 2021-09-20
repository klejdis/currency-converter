package com.kj.currencyconverter.controller;

import com.kj.currencyconverter.bean.CurrencyConverterBean;
import com.kj.currencyconverter.service.CurrencyConverterService;
import com.kj.currencyconverter.service.ExchangeRatesApiClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConverterController {

    @GetMapping("currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConverterBean convert(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable Double quantity
    ){

        ExchangeRatesApiClient exchangeRatesApiClient = new ExchangeRatesApiClient();
        CurrencyConverterService currencyConverterService = new CurrencyConverterService(exchangeRatesApiClient);

        return  currencyConverterService.convert(from,to,quantity);
    }
}
