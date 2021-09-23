package com.kj.currencyconverter.services.currencyconverter;

import com.kj.currencyconverter.bean.CurrencyConverterBean;
import com.kj.currencyconverter.models.Currency;
import com.kj.currencyconverter.repositories.CurrencyRepository;
import com.kj.currencyconverter.services.currencyconverter.clients.FixerApiClient;
import com.kj.currencyconverter.services.currencyconverter.exceptions.CurrencyNotFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class CurrencyConverterServiceTest {

    @Mock
    private CurrencyRepository currencyRepository;

    private CurrencyConverterService currencyConverterService;

    @Before
    public void setUp() {

        FixerApiClient fixerApiClient = new FixerApiClient("");
        currencyConverterService = new CurrencyConverterService(fixerApiClient,currencyRepository);

    }


    @Test
    public void convert() {

        Optional<Currency> eur = Optional.of(new Currency("EUR", 1));
        Optional<Currency> usd = Optional.of(new Currency("USD", 1.17));

        Mockito.when(currencyRepository.findById("EUR")).thenReturn(eur);
        Mockito.when(currencyRepository.findById("USD")).thenReturn(usd);

        CurrencyConverterBean currencyConverterBean = null;

        try {
            currencyConverterBean = currencyConverterService.convert("EUR","USD", 100.0);
        } catch (CurrencyNotFoundException currencyNotFoundException) {
            currencyNotFoundException.printStackTrace();
        }


        Double expected = Double.valueOf(117);
        Double actual = currencyConverterBean.getCalculatedAmount();
        Assert.assertEquals( expected , actual);


    }

    @Test(expected = NullPointerException.class)
    public void convertTestNullPointerException() throws NullPointerException, CurrencyNotFoundException {

        Mockito.when(currencyRepository.findById("EURO")).thenReturn(null);
        Mockito.when(currencyRepository.findById("USD")).thenReturn(null);

        CurrencyConverterBean currencyConverterBean = null;

        currencyConverterBean = currencyConverterService.convert("EURO","USD", 100.0);
    }
}