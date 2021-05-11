package com.example.CoinAPI.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Coin {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String ticker;
    private int numOfCoins;
    private Long marketCap;

    Coin() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public void setNumOfCoins(int numOfCoins) {
        this.numOfCoins = numOfCoins;
    }

    public void setMarketCap(Long marketCap) {
        this.marketCap = marketCap;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTicker() {
        return ticker;
    }

    public int getNumOfCoins() {
        return numOfCoins;
    }

    public Long getMarketCap() {
        return marketCap;
    }

    //builder design pattern
    public static class Builder {

        @Id
        @GeneratedValue
        private Long id;

        private String name;
        private String ticker;
        private int numOfCoins;
        private Long marketCap;

        public Builder(String name) {
            this.name = name;
        }

        public Builder withTicker(String ticker) {
            this.ticker = ticker;
            return this;
        }

        public Builder withNumOfCoins(int numOfCoins) {
            this.numOfCoins = numOfCoins;
            return this;
        }

        public Builder withMarketCap(Long marketCap) {
            this.marketCap = marketCap;
            return this;
        }

        public Coin build() {
            Coin coin = new Coin();
            coin.name = this.name;
            coin.ticker = this.ticker;
            coin.numOfCoins = this.numOfCoins;
            coin.marketCap = this.marketCap;

            return coin;

        }


    }


    @Override
    public String toString() {
        return "Coin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ticker='" + ticker + '\'' +
                ", numOfCoins=" + numOfCoins +
                ", marketCap=" + marketCap +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coin coin = (Coin) o;
        return Objects.equals(id, coin.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
