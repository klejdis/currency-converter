package com.kj.currencyconverter.services.currencyconverter;

import com.kj.currencyconverter.bean.CurrencyConverterBean;
import com.kj.currencyconverter.models.Currency;
import com.kj.currencyconverter.repositories.CurrencyRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestPropertySource("classpath:application.properties")
public class IntegrationTest {

    @Mock
    private CurrencyRepository currencyRepository;

    private RestTemplate restTemplate;

    private String basePath = "http://localhost:8080/currency-converter/";


    @Before
    public void setUp(){
        restTemplate = new RestTemplate();
    }

    @Test
    public void convert(){
        Optional<Currency> eur = Optional.of(new Currency("EUR", 1));
        Optional<Currency> usd = Optional.of(new Currency("USD", 1.17));

        Mockito.when(currencyRepository.findById("EUR")).thenReturn(eur);
        Mockito.when(currencyRepository.findById("USD")).thenReturn(usd);


        CurrencyConverterBean converterBeanResponseEntity = restTemplate.getForObject(basePath+"/from/EUR/to/USD/quantity/100",CurrencyConverterBean.class);

        //Assert.assertEquals(converterBeanResponseEntity.getStatusCode(), HttpStatus.OK);

    }

}
