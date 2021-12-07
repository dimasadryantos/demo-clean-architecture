package com.dzcorp.service.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CreationOrderControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    void itShouldCreateOrder() throws Exception {
        final String order = "{" +"\"components\"  : " + "[\"C\",\"A\"]" + "}";

        ResultActions resultActions = mockMvc.perform(post("/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .content(order));

        resultActions.andExpect(status().isCreated());
        resultActions.andExpect(jsonPath("$.orderId").isNotEmpty());
        resultActions.andExpect(jsonPath("$.total").value(10));
    }


}