package com.example.CoinAPI.service;

import com.example.CoinAPI.model.Coin;
import com.example.CoinAPI.repo.CoinRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoinService {

    @Autowired
    private CoinRepo repo;

    public List<Coin> getAllCoins(int pageNum, int pageSize, String sortBy) {
        Pageable page = PageRequest.of(pageNum, pageSize, Sort.by(sortBy));
        Page<Coin> result = repo.findAll(page);

        if (result.hasContent()) {
            return result.getContent();
        } else {
            return new ArrayList<>();
        }
    }

    public Coin getCoin(Long id) {
        return repo.getOne(id);
    }

    public Coin createCoin(Coin newCoin) {
        return repo.save(newCoin);
    }

    public void deleteById(long id) {
        repo.deleteById(id);
    }

    public void deleteAll() {
        repo.deleteAll();
    }

    public Coin replaceCoin(long id, Coin newCoin) {
        // TODO try it out
        return repo.save(newCoin);
    }
}
