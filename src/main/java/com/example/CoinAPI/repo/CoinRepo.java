package com.example.CoinAPI.repo;

import com.example.CoinAPI.model.Coin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface CoinRepo extends JpaRepository<Coin, Long> {



}
