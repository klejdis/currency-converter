package com.kj.currencyconverter.controller;

import com.kj.currencyconverter.bean.CurrencyConverterBean;
import com.kj.currencyconverter.models.Currency;
import com.kj.currencyconverter.repositories.CurrencyRepository;
import com.kj.currencyconverter.services.currencyconverter.CurrencyConverterFactory;
import com.kj.currencyconverter.services.currencyconverter.CurrencyConverterService;
import com.kj.currencyconverter.services.currencyconverter.exceptions.CurrencyNotFoundException;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Optional;

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
    @RequestMapping(value = "from/{from}/to/{to}/quantity/{quantity}",produces = {"application/json"}, method = RequestMethod.GET)
    public ResponseEntity<?> convert(
           @NotNull @PathVariable String from,
           @NotNull @PathVariable String to,
           @NotNull @Positive @PathVariable Double quantity
    ) throws Exception {

        try{
            CurrencyConverterService currencyConverterService = currencyConverterFactory.getService();
            CurrencyConverterBean currencyConverterBean = currencyConverterService.convert(from,to,quantity);

            return  new ResponseEntity<>(currencyConverterBean, HttpStatus.OK);

        }catch (CurrencyNotFoundException currencyNotFoundException){
            return  new ResponseEntity<CurrencyNotFoundException>(currencyNotFoundException, HttpStatus.UNPROCESSABLE_ENTITY);
        }

    }
}
