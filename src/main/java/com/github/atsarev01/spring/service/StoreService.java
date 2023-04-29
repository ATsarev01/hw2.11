package com.github.atsarev01.spring.service;

import com.github.atsarev01.spring.model.Basket;
import com.github.atsarev01.spring.model.Item;
import com.github.atsarev01.spring.model.Store;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoreService {

    private final Basket basket;

    private final Store store;

    public StoreService(Basket basket, Store store) {
        this.basket = basket;
        this.store = store;
    }

    public void add(List<Integer> ids) {
        basket.add(ids);
    }

    public List<Item> get() {
        return store.get().stream()
                .filter(item -> basket.getIds().contains(item.getId()))
                .collect(Collectors.toList());
    }
}
