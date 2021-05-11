package com.example.CoinAPI.service;

import com.example.CoinAPI.model.Coin;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootTest
public class CoinServiceTest {

    @Autowired
    private CoinService service;

    private List<Coin> expectedCurrentCoins;

    @BeforeEach
    private void beforeEach() {
        expectedCurrentCoins = new ArrayList<>();
        service.deleteAll();
        expectedCurrentCoins.add(service.createCoin(new Coin.Builder("shitcoin 1").build()));
        expectedCurrentCoins.add(service.createCoin(new Coin.Builder("shitcoin 2").build()));
    }

    @AfterEach
    private void afterEach() {
        service.deleteAll();
        expectedCurrentCoins.clear();
    }

    @Test
    public void getAllCoins() {
        List<Coin> coins = service.getAllCoins(0, 10, "id");
        Assertions.assertEquals(2, coins.size());
        Assertions.assertIterableEquals(expectedCurrentCoins, coins);
    }

    @Test
    public void createCoin() {
        Coin createdCoin = service.createCoin(new Coin.Builder("shitcoin 3").build());

        Coin coin = service.getCoin(createdCoin.getId());
        Assertions.assertEquals(createdCoin, coin);

        expectedCurrentCoins.add(createdCoin);
        List<Coin> coins = service.getAllCoins(0, 10, "id");
        Assertions.assertEquals(3, coins.size());
        Assertions.assertIterableEquals(expectedCurrentCoins, coins);
    }
}
