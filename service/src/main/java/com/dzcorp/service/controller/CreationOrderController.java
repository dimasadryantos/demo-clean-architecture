package com.dzcorp.service.controller;

import com.dzcorp.client.request.CreationOrderRestRequest;
import com.dzcorp.client.response.CreationOrderRestResponse;
import com.dzcorp.service.exception.BadRequestException;
import com.dzcorp.core.usecase.CreationOrderInputBoundary;
import com.dzcorp.core.usecase.CreationOrderRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreationOrderController {


    private final CreationOrderInputBoundary useCase;

    public CreationOrderController(CreationOrderInputBoundary useCase) {
        this.useCase = useCase;
    }

    @PostMapping(value = "/orders", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public CreationOrderRestResponse create(@RequestBody CreationOrderRestRequest orderRestRequest) {
        try {
            CreationOrderRequest orderRequest = new CreationOrderRequest(orderRestRequest.getComponents());
            CreationOrderPresenter presenter = new CreationOrderPresenter();
            useCase.create(orderRequest, presenter);
            return presenter.getRestResponse();
        } catch (BadRequestException exception) {
            throw new BadRequestException("Invalid Request");
        }
    }


}
