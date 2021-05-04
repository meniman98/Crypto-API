package com.example.CoinAPI.exception;

public class CoinNotFoundException extends RuntimeException {
    public CoinNotFoundException(Long id) {
        super("This coin wasn't found: " + id);

    }
}
