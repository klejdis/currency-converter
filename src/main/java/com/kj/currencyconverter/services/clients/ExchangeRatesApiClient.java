package com.kj.currencyconverter.services.clients;

import com.kj.currencyconverter.bean.CurrencyConverterBean;
import com.kj.currencyconverter.bean.CurrencyDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class ExchangeRatesApiClient implements ExchangeRateClientInterface {


    public CurrencyConverterBean convert(String from, String to, Double quantity){

        ResponseEntity<CurrencyDTO> responseEntity = null;

        responseEntity = new RestTemplate().getForEntity("http://api.exchangeratesapi.io/v1/latest?access_key=dfb6f1954e9b9fdc285f4251475fc90b",
                CurrencyDTO.class);

        Map<String, Double> rates =  responseEntity.getBody().getRates();
        Double fromValue = rates.get(from);
        Double toValue = rates.get(to);

        Double calculatedAmount = toValue * quantity / fromValue;

        return new CurrencyConverterBean(from,to,quantity,toValue,calculatedAmount);
    }

}
