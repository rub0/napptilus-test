package com.example.napptilus.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc(addFilters = false)
@SpringBootTest
public class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testNapptilusCases() throws Exception {
        mockMvc.perform(get("/brands/1/products/35455?applicationDate=2020-06-14-10.00.00").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price", is("35.50")));

        mockMvc.perform(get("/brands/1/products/35455?applicationDate=2020-06-14-16.00.00").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price", is("25.45")));

        mockMvc.perform(get("/brands/1/products/35455?applicationDate=2020-06-14-21.00.00").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price", is("35.50")));

        mockMvc.perform(get("/brands/1/products/35455?applicationDate=2020-06-15-10.00.00").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price", is("30.50")));

        mockMvc.perform(get("/brands/1/products/35455?applicationDate=2020-06-16-21.00.00").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price", is("38.95")));
    }

    @Test
    public void NotFoundProduct() throws Exception {
        mockMvc.perform(get("/brands/2/products/35455?applicationDate=2020-06-16-21.00.00").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

        mockMvc.perform(get("/brands/1/products/35455?applicationDate=2020-06-01-21.00.00").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
