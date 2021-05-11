package com.example.CoinAPI.controller;

import com.example.CoinAPI.service.CoinService;
import com.example.CoinAPI.model.Coin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class CoinController {

    private final String currencies = "/currencies";
    private static final Logger log = LoggerFactory.getLogger(CoinController.class);

    @Autowired
    private CoinService service;

    // get all coins
    @GetMapping(currencies)
    public ResponseEntity<List<Coin>> getAllCoins(
            @RequestParam(defaultValue = "0") int pageNum,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {

        // TODO test
        if (pageNum < 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(service.getAllCoins(pageNum, pageSize, sortBy), HttpStatus.OK);
    }

    // get one coin
    @GetMapping(currencies + "/{id}")
    public ResponseEntity<Coin> returnOne(@PathVariable Long id) {
        return new ResponseEntity<>(service.getCoin(id), HttpStatus.OK);
    }

    //make one coin
    @PostMapping(currencies)
    Coin newCoin(@RequestBody Coin newCoin) {
        return service.createCoin(newCoin);
    }

    //edit one coin
    @PutMapping(currencies + "/{id}")
    Coin editCoin(@RequestBody Coin newCoin, @PathVariable long id) {
        return service.replaceCoin(id, newCoin);
    }

    @DeleteMapping(currencies + "/{id}")
    void deleteCoin(@PathVariable long id) {
        service.deleteById(id);
    }
}
