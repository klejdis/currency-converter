package com.kj.currencyconverter.tasks;

import com.kj.currencyconverter.bean.CurrencyDTO;
import com.kj.currencyconverter.models.Currency;
import com.kj.currencyconverter.repositories.CurrencyRepository;
import com.kj.currencyconverter.services.currencyconverter.CurrencyConverterFactory;
import com.kj.currencyconverter.services.currencyconverter.CurrencyConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * This Task will grab the rates from the
 * Currency Converter Service and based on
 * how spring.rates.provider is set it will get rates from
 * https://exchangeratesapi.io/ or https://fixer.io/
 */
@Component
public class ImportRatesTask {
    @Autowired
    private CurrencyRepository currencyRepository;

    @Autowired
    private CurrencyConverterFactory currencyConverterFactory;

    //runs every 5 hours
    @Scheduled(fixedRate = 5 * 1000 * 60 * 60)
    private void getRatesTask() throws Exception {
        //get the service
       CurrencyConverterService currencyConverterService = currencyConverterFactory.getService();

       //grab the rates
       CurrencyDTO currenciesWithRates  =  currencyConverterService.getExchangeRateClient().getRates();

       //store each rate on redis
        currenciesWithRates.getRates().forEach((key, value) -> {
           Currency currency = new Currency(key, value);
           currencyRepository.save(currency);
       });
    }
}
