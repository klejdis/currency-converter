package com.kj.currencyconverter.controller;

import com.kj.currencyconverter.bean.CurrencyConverterBean;
import com.kj.currencyconverter.services.CurrencyConverterService;
import com.kj.currencyconverter.services.clients.ExchangeRatesApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("currency-converter/")
public class CurrencyConverterController {

    /**
     * This is the endpoint to convert a currency from -> to for a given quantity
     *
     * @param from
     * @param to
     * @param quantity
     * @return
     */
    @GetMapping("from/{from}/to/{to}/quantity/{quantity}")
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
