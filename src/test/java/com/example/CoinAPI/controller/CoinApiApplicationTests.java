package com.example.CoinAPI.controller;

import com.example.CoinAPI.TestUtil;
import com.example.CoinAPI.model.Coin;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class CoinApiApplicationTests {

    @Autowired
    private CoinController controller;

    @Autowired
    private MockMvc mvc;


    @BeforeEach
    private void beforeEach() {

    }

    @AfterEach
    private void afterEach() {

    }

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

    // check if post works by creating a new Coin, then using the post request to see if a status 200 is given
    @Test
    void postCoin() throws Exception {
        Coin coin = new Coin.Builder("sumCoin").build();

        mvc.perform(post("/currencies")
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.toJson(coin)))
                .andExpect(status().is2xxSuccessful());
    }


}
