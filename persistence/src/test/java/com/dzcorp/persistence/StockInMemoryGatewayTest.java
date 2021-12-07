package com.dzcorp.persistence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.of;

class StockInMemoryGatewayTest {


    @InjectMocks
    private StockInMemoryGateway stockInMemoryGateway;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @ParameterizedTest
    @MethodSource("getInput")
    void itShouldSaveStock(String code, Stock stock) {
        //given
        //when
        stockInMemoryGateway.save(code, stock);
        //then
        Map<String, Stock> inMemoryGatewayStock = stockInMemoryGateway.getStock();

        assertThat(inMemoryGatewayStock.get(code)).isEqualTo(stock);
    }


    private static Stream<Arguments> getInput() {
        return Stream.of(
                of("D", new Stock("D", "LEG", 2)),
                of("C", new Stock("C", "DICK", 2))
        );
    }


}