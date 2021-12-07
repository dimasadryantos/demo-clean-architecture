package com.dzcorp.service.controller;

import com.dzcorp.client.response.CreationOrderRestResponse;
import com.dzcorp.core.usecase.CreationOrderOuputBoundary;
import com.dzcorp.core.usecase.CreationOrderResponse;

public class CreationOrderPresenter implements CreationOrderOuputBoundary {


    private CreationOrderRestResponse restResponse;

    @Override
    public void present(CreationOrderResponse response) {
        restResponse = new CreationOrderRestResponse();
        restResponse.setOrderId(response.getOrderId());
        restResponse.setTotal(response.getTotal());
    }


    public CreationOrderRestResponse getRestResponse() {
        return restResponse;
    }
}
