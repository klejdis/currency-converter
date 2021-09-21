package com.kj.currencyconverter.controller;

import com.kj.currencyconverter.bean.CurrencyConverterBean;
import com.kj.currencyconverter.services.CurrencyConverterFactory;
import com.kj.currencyconverter.services.CurrencyConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("currency-converter/")
public class CurrencyConverterController {

    @Autowired
    private CurrencyConverterFactory currencyConverterFactory;

    /**
     * This is the endpoint to convert a currency from -> to for a given quantity
     *
     * @param from
     * @param to
     * @param quantity
     * @return CurrencyConverterBean
     */
    @GetMapping("from/{from}/to/{to}/quantity/{quantity}")
    public ResponseEntity<CurrencyConverterBean> convert(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable Double quantity
    ){
        CurrencyConverterService currencyConverterService = currencyConverterFactory.getService();
        return  new ResponseEntity<>( currencyConverterService.convert(from,to,quantity), HttpStatus.OK);
    }
}
