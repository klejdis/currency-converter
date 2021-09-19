package com.kj.currencyconverter.bean;

import java.math.BigDecimal;

public class CurrencyConverterBean {

    private String from;
    private String to;
    private BigDecimal quantity;
    private BigDecimal rate;
    private BigDecimal calculatedAmount;

    public CurrencyConverterBean(String from, String to, BigDecimal quantity, BigDecimal rate, BigDecimal calculatedAmount) {
        this.from = from;
        this.to = to;
        this.quantity = quantity;
        this.rate = rate;
        this.calculatedAmount = calculatedAmount;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getCalculatedAmount() {
        return calculatedAmount;
    }

    public void setCalculatedAmount(BigDecimal calculatedAmount) {
        this.calculatedAmount = calculatedAmount;
    }
}
