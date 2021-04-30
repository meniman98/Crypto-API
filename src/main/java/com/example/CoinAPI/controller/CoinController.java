package com.example.CoinAPI.controller;

import com.example.CoinAPI.repo.CoinRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoinController {
    private final String currencies = "currencies";
    private CoinRepo repo;

    @GetMapping("/" + currencies)
    public ResponseEntity<List>


}
