package com.kj.currencyconverter.services.currencyconverter.clients;

import com.kj.currencyconverter.bean.CurrencyConverterBean;
import com.kj.currencyconverter.bean.CurrencyDTO;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

public class ExchangeRatesApiClient extends ExchangeClientBaseClass {

    public ExchangeRatesApiClient(String uri) {
        super(uri);
    }

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
        CurrencyDTO currencies = restTemplate.getForObject(uri,
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
            return restTemplate.getForObject(uri,
                    CurrencyDTO.class);
        } catch (RestClientException ex){
            System.out.println(ex.getMessage());
        }

        return null;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
