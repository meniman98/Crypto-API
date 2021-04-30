package com.example.CoinAPI.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Coin {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String ticker;
    private int numOfCoins;
    private Long marketCap;


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

    public static void main(String[] args) {


        // quick tests
        Coin coin = new Coin.Builder("bitcoin")
                .withTicker("ticker").build();

        Coin coin2 = new Coin.Builder("another coin")
                .withMarketCap(199999999L).build();

        System.out.println(coin.toString());
        System.out.println(coin2.toString());
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
    private Coin() {
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
}
