package com.dzcorp.core.usecase;

public interface CreationOrderInputBoundary {

    void create(CreationOrderRequest request, CreationOrderOuputBoundary presenter);
}
