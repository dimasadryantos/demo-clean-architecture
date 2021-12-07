package com.dzcorp.core.usecase;


import com.dzcorp.persistence.Stock;
import com.dzcorp.persistence.StockGateway;

import java.util.Map;
import java.util.UUID;

public class CreationOrderUseCase implements CreationOrderInputBoundary {


    private final StockGateway stockGateWay;

    public CreationOrderUseCase(StockGateway stockGateWay) {
        this.stockGateWay = stockGateWay;
    }


    @Override
    public void create(CreationOrderRequest request, CreationOrderOuputBoundary presenter) {
        Map<String, Stock> allStock = stockGateWay.getStock();
        Stock stock = allStock.get(request.getComponents().get(1));

        CreationOrderResponse response = new CreationOrderResponse();
        response.setOrderId(UUID.randomUUID().toString());
        response.setTotal(stock.getAvailable());

        presenter.present(response);
    }
}
