package com.kj.currencyconverter.bean;


public class CurrencyConverterBean {

    private String from;
    private String to;
    private Double quantity;
    private Double rate;
    private Double calculatedAmount;

    public CurrencyConverterBean() {
    }

    public CurrencyConverterBean(String from, String to, Double quantity, Double rate, Double calculatedAmount) {
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

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getCalculatedAmount() {
        return calculatedAmount;
    }

    public void setCalculatedAmount(Double calculatedAmount) {
        this.calculatedAmount = calculatedAmount;
    }
}
