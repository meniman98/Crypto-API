package com.example.CoinAPI.controller;

import com.example.CoinAPI.CoinService;
import com.example.CoinAPI.model.Coin;
import com.example.CoinAPI.repo.CoinRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CoinController {
    private final String currencies = "/currencies";

    @Autowired
    CoinService service;



    @GetMapping(currencies)
    public ResponseEntity<List<Coin>> getAllCoins(
            @RequestParam(defaultValue = "0") int pageNum,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "id") String sortBy)
     {
    List<Coin> list = service.getAllCoins(pageNum, pageSize, sortBy);

        return new ResponseEntity<List<Coin>>(list, new HttpHeaders(), HttpStatus.OK);
    }


}
