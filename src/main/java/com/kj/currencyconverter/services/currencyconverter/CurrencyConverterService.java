package com.kj.currencyconverter.services.currencyconverter;

import com.kj.currencyconverter.bean.CurrencyConverterBean;
import com.kj.currencyconverter.models.Currency;
import com.kj.currencyconverter.repositories.CurrencyRepository;
import com.kj.currencyconverter.services.currencyconverter.clients.ExchangeRateClientInterface;
import com.kj.currencyconverter.services.currencyconverter.exceptions.CurrencyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CurrencyConverterService {

    private ExchangeRateClientInterface exchangeRateClient;

    private CurrencyRepository currencyRepository;

    public CurrencyConverterService() {
    }

    /**
     * Constructor for CurrencyConverterService
     * it takes ExchangeRateClientInterface as param and any client that implements this interface
     * can be accepted. This way this class is open for extension
     *
     * @param
     */
    public CurrencyConverterService(ExchangeRateClientInterface exchangeRateClient, CurrencyRepository currencyRepository) {
        this.exchangeRateClient = exchangeRateClient;
        this.currencyRepository = currencyRepository;
    }

    /**
     * The main method to convert taking the rates live
     * from the api
     *
     * @param from
     * @param to
     * @param quantity
     * @return CurrencyConverterBean
     */
    public CurrencyConverterBean convertLive(String from, String to, Double quantity){
       return this.exchangeRateClient.convert(from,to,quantity);
    }

    /**
     * The main method to convert taking the rates live
     * from the api
     *
     * @param from
     * @param to
     * @param quantity
     * @return CurrencyConverterBean
     */
    public CurrencyConverterBean convert(String from, String to, Double quantity) throws CurrencyNotFoundException {

        Optional<Currency> toOptional = this.currencyRepository.findById(to.toUpperCase());
        Optional<Currency> fromOptional = this.currencyRepository.findById(from.toUpperCase());

        if(!toOptional.isPresent() && !fromOptional.isPresent()) {
            throw new CurrencyNotFoundException("Currency Not Found");
        }

        Currency toCurrency = toOptional.get();
        Currency fromCurrency = fromOptional.get();

        Double result = toCurrency.getValueInEuros() * quantity / fromCurrency.getValueInEuros();

        return new CurrencyConverterBean(from,to,quantity,toCurrency.getValueInEuros(),result);
    }

    public ExchangeRateClientInterface getExchangeRateClient() {
        return exchangeRateClient;
    }

    public void setExchangeRateClient(ExchangeRateClientInterface exchangeRateClient) {
        this.exchangeRateClient = exchangeRateClient;
    }
}
