package com.example.CoinAPI.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Coin {

    @Id
    @GeneratedValue
    private Long id;

    private String ticker;
    private String name;
    private int numOfCoins;
    private Long marketCap;





}
