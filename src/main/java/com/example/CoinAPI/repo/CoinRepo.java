package com.example.CoinAPI.repo;

import com.example.CoinAPI.model.Coin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoinRepo extends JpaRepository<Coin, Long> {


}
