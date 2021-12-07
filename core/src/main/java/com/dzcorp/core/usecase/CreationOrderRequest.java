package com.dzcorp.core.usecase;

import java.util.List;

public class CreationOrderRequest {


    private List<String> components;


    public CreationOrderRequest(List<String> components) {
        this.components = components;
    }

    public List<String> getComponents() {
        return components;
    }

    public void setComponents(List<String> components) {
        this.components = components;
    }
}
