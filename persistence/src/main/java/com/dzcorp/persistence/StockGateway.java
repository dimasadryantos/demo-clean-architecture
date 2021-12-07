package com.dzcorp.persistence;

import java.util.Map;

public interface StockGateway {

    void save(String code, Stock stock);

    Map<String, Stock> getStock();


}
