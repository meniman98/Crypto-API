package com.example.CoinAPI;

import com.example.CoinAPI.controller.CoinController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

    @Test
    void getRequest() throws Exception {
        // this doesn't work
        this.mvc.perform(get("/currencies")).andExpect(status().is2xxSuccessful());
    }

    @Test
    void getSingleCoin() throws Exception {
        this.mvc.perform(get("/currencies/1")).andExpect(status().is2xxSuccessful());
    }


}
