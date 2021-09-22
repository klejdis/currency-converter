package com.kj.currencyconverter.controller;

import com.kj.currencyconverter.bean.CurrencyConverterBean;
import com.kj.currencyconverter.models.Currency;
import com.kj.currencyconverter.repositories.CurrencyRepository;
import com.kj.currencyconverter.services.CurrencyConverterFactory;
import com.kj.currencyconverter.services.CurrencyConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@RestController
@RequestMapping("currency-converter/")
public class CurrencyConverterController {

    @Autowired
    private CurrencyConverterFactory currencyConverterFactory;

    @Autowired
    private CurrencyRepository currencyRepository;

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
           @NotNull @PathVariable String from,
           @NotNull @PathVariable String to,
           @NotNull @PathVariable Double quantity
    ) throws Exception {
        CurrencyConverterService currencyConverterService = currencyConverterFactory.getService();

        Optional<Currency> fromCurrency = currencyRepository.findById(from.toUpperCase());
        Optional<Currency> toCurrency = currencyRepository.findById(from.toUpperCase());


        return  new ResponseEntity<>( currencyConverterService.convert(from,to,quantity)
                , HttpStatus.OK);
    }
}
