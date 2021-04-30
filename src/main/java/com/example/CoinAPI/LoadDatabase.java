package com.example.CoinAPI;

import com.example.CoinAPI.model.Coin;
import lombok.extern.slf4j.Slf4j;
import com.example.CoinAPI.repo.CoinRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(CoinRepo repo) {
        return args -> {
            Coin bitcoin = new Coin.Builder("Bitcion").withTicker("BTC").withNumOfCoins(16_770_000).withMarketCap(189_580_000_000L).build();
            System.out.println("Loading " + repo.save(new Coin.Builder("Bitcoin").build()));
            System.out.println("Loading " + repo.save(new Coin.Builder("Some coin").build()));
            System.out.println("Loading " + repo.save(new Coin.Builder("Another coin").build()));
        };
    }
}
