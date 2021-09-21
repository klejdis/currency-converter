package com.kj.currencyconverter.services.clients;

import com.kj.currencyconverter.bean.CurrencyConverterBean;
import com.kj.currencyconverter.bean.CurrencyDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Locale;
import java.util.Map;

@Component
public class ExchangeRatesApiClient implements ExchangeRateClientInterface {


    /**
     * Converts the currency from -> to for given quantity
     *
     * @param from
     * @param to
     * @param quantity
     * @return CurrencyConverterBean
     */
    public CurrencyConverterBean convert(String from, String to, Double quantity){

        RestTemplate restTemplate = new RestTemplate();
        CurrencyDTO currencies = restTemplate.getForObject("http://api.exchangeratesapi.io/v1/latest?access_key=dfb6f1954e9b9fdc285f4251475fc90b",
                CurrencyDTO.class);

        Map<String, Double> rates =  currencies.getRates();
        Double fromValue = rates.get(from.toUpperCase());
        Double toValue = rates.get(to.toUpperCase());

        Double calculatedAmount = toValue * quantity / fromValue;

        return new CurrencyConverterBean(from,to,quantity,toValue,calculatedAmount);
    }

    @Override
    public CurrencyDTO getRates() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            return restTemplate.getForObject("http://api.exchangeratesapi.io/v1/latest?access_key=dfb6f1954e9b9fdc285f4251475fc90b",
                    CurrencyDTO.class);
        } catch (RestClientException ex){
            System.out.println(ex.getMessage());
        }

        return null;
    }
}
