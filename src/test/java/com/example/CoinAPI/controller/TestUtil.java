package com.example.CoinAPI.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;

public class TestUtil {

    private final static ObjectMapper objectMapper = new ObjectMapper();

    public static String toJson(final Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception exception) {
            Assertions.fail("failed during toJson()", exception);
        }

        return null;
    }
}
