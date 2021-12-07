package com.dzcorp.persistence;

import java.util.HashMap;
import java.util.Map;

public class StockInMemoryGateway implements StockGateway {

    //for future if we want to use JPA
    private StockRepository repository;

    private final Map<String, Stock> inMemoryData = new HashMap<>();

    @Override
    public void save(String code, Stock stock) {
        inMemoryData.put(code, stock);
    }

    @Override
    public Map<String, Stock> getStock() {
        inMemoryData.put("A", new Stock("A", "FACE", 10));
        return inMemoryData;
    }
}
