package com.kj.currencyconverter.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import javax.validation.constraints.NotBlank;

@RedisHash("Currency")
public class Currency {

    @Id
    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "value In Euros is mandatory")
    private Double valueInEuros;

    public Currency() {
    }

    public Currency(String name, double valueInEuros) {
        this.name = name;
        this.valueInEuros = valueInEuros;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValueInEuros() {
        return valueInEuros;
    }

    public void setValueInEuros(Double valueInEuros) {
        this.valueInEuros = valueInEuros;
    }
}
