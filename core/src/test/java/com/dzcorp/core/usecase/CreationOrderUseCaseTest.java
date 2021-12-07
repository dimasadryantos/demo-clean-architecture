package com.dzcorp.core.usecase;

import com.dzcorp.persistence.Stock;
import com.dzcorp.persistence.StockGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CreationOrderUseCaseTest {


    @InjectMocks
    private CreationOrderUseCase useCase;

    @Mock
    private CreationOrderOuputBoundary presenter;

    @Mock
    private StockGateway stockGateway;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void itShouldReturnCorrectResponse() {
        //given
        CreationOrderRequest creationOrderRequest = new CreationOrderRequest(Arrays.asList("C", "A"));
        when(stockGateway.getStock()).thenReturn(getStock());
        //when
        useCase.create(creationOrderRequest, presenter);

        ArgumentCaptor<CreationOrderResponse> argumentCaptor = ArgumentCaptor.forClass(CreationOrderResponse.class);
        verify(presenter, times(1)).present(argumentCaptor.capture());


        CreationOrderResponse actualResponse = argumentCaptor.getValue();
        //then

        assertThat(actualResponse.getOrderId()).isNotEmpty();
        assertThat(actualResponse.getTotal()).isEqualTo(10);
    }


    public Map<String, Stock> getStock() {
        Map<String, Stock> inMemoryData = new HashMap<>();
        inMemoryData.put("A", new Stock("A", "FACE", 10));
        return inMemoryData;
    }
}