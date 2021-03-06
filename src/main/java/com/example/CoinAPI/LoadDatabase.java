package com.example.CoinAPI;

import com.example.CoinAPI.controller.CoinController;
import com.example.CoinAPI.model.Coin;
import com.example.CoinAPI.repo.CoinRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(CoinController.class);

    @Bean
    CommandLineRunner initDatabase(CoinRepo repo) {
        return args -> {
            Coin bitcoin = new Coin.Builder("Bitcoin").withTicker("BTC").withNumOfCoins(16_770_000).withMarketCap(189_580_000_000L).build();
            Coin ethereum = new Coin.Builder("Ethereum").withTicker("ETH").withNumOfCoins(96_710_000).withMarketCap(69_280_000_000L).build();
            Coin ripple = new Coin.Builder("Ripple").withTicker("XRP").withNumOfCoins(38_590_000).withMarketCap(64_750_000_000L).build();
            Coin bitcoinCash = new Coin.Builder("BitcoinCash").withTicker("BCH").withNumOfCoins(16_670_000).withMarketCap(69_020_000_000L).build();
            log.info("Loading " + repo.save(bitcoin));
            log.info("Loading " + repo.save(ethereum));
            log.info("Loading " + repo.save(ripple));
            log.info("Loading " + repo.save(bitcoinCash));
        };
    }
}
