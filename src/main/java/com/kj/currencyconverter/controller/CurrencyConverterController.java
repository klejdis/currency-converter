package com.kj.currencyconverter.controller;

import com.kj.currencyconverter.bean.CurrencyConverterBean;
import com.kj.currencyconverter.models.Currency;
import com.kj.currencyconverter.repositories.CurrencyRepository;
import com.kj.currencyconverter.services.currencyconverter.CurrencyConverterFactory;
import com.kj.currencyconverter.services.currencyconverter.CurrencyConverterService;
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
    public ResponseEntity<CurrencyConverterBean> convert(
           @NotNull @PathVariable String from,
           @NotNull @PathVariable String to,
           @NotNull @Positive @PathVariable Double quantity
    ) throws Exception {
        CurrencyConverterService currencyConverterService = currencyConverterFactory.getService();


        return  new ResponseEntity<>( currencyConverterService.convert(from,to,quantity)
                , HttpStatus.OK);
    }
}
