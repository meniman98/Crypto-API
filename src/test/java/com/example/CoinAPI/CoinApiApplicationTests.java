package com.example.CoinAPI;

import com.example.CoinAPI.controller.CoinController;
import com.example.CoinAPI.model.Coin;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class CoinApiApplicationTests {

    @Autowired
    private CoinController controller;

    @Autowired
    private MockMvc mvc;

    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }

    // check if get request is successful, and if 4 JSON objects are returned
    @Test
    void getRequest() throws Exception {
        this.mvc.perform(get("/currencies")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$", hasSize(4)));
    }

    // check if a single coin can be retrieved and if the name is "Bitcoin"
    @Test
    void getSingleCoin() throws Exception {
        this.mvc.perform(get("/currencies/1")).andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.name", Matchers.is("Bitcoin")));
    }

}
