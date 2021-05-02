package com.example.CoinAPI.controller;

import com.example.CoinAPI.CoinService;
import com.example.CoinAPI.Exception.CoinNotFoundException;
import com.example.CoinAPI.model.Coin;
import com.example.CoinAPI.repo.CoinRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class CoinController {
    private final String currencies = "/currencies";
    private static final Logger log = LoggerFactory.getLogger(CoinController.class);
    private final CoinRepo repo;

    @Autowired
    CoinService service;

    CoinController(CoinRepo repo) {
        this.repo = repo;
    }


    @GetMapping(currencies)
    ResponseEntity<List<Coin>> getAllCoins(
            @RequestParam(defaultValue = "0") int pageNum,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "id") String sortBy)
     {
    List<Coin> list = service.getAllCoins(pageNum, pageSize, sortBy);
    log.info("Get request works!");

        return new ResponseEntity<List<Coin>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(currencies + "/{id}")
    Coin returnOne(@PathVariable Long id) {
        return repo.findById(id)
                .orElseThrow( () -> new CoinNotFoundException(id) )
    }


}
