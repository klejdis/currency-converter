package com.kj.currencyconverter.tasks;

import com.kj.currencyconverter.bean.CurrencyDTO;
import com.kj.currencyconverter.models.Currency;
import com.kj.currencyconverter.repositories.CurrencyRepository;
import com.kj.currencyconverter.services.CurrencyConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ImportRatesTask {

    @Autowired
    private CurrencyRepository currencyRepository;

    @Autowired
    private CurrencyConverterService currencyConverterService;

    //runs evert 5 hours
    @Scheduled(fixedRate = 5 * 1000 * 60 * 60)
    private void getRatesTask(){

       CurrencyDTO currenciesWithRates  =  currencyConverterService.getExchangeRateClient().getRates();

        currenciesWithRates.getRates().forEach((key, value) -> {
           Currency currency = new Currency(key, value);
           currencyRepository.save(currency);
       });


    }

}
