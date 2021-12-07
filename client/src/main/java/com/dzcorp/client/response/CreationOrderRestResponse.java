package com.dzcorp.client.response;

public class CreationOrderRestResponse {


    private String orderId;

    private Integer total;


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
