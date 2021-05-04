package com.example.CoinAPI;

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
    CoinRepo repo;

    public List<Coin> getAllCoins(int pageNum, int pageSize, String sortBy) {
        Pageable page = PageRequest.of(pageNum, pageSize, Sort.by(sortBy));
        Page<Coin> result = repo.findAll(page);

        if (result.hasContent()) {
            return result.getContent();
        } else {
            return new ArrayList<Coin>();
        }

    }
}
