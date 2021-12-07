package com.dzcorp.persistence;

public class Stock {

    private String code;

    private String component;

    private Integer available;


    public Stock(String code, String component, Integer available) {
        this.code = code;
        this.component = component;
        this.available = available;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "code='" + code + '\'' +
                ", component='" + component + '\'' +
                ", available=" + available +
                '}';
    }
}
