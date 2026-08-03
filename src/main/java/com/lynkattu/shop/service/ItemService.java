package com.lynkattu.shop.service;


import com.lynkattu.shop.model.ItemModel;
import com.lynkattu.shop.model.ItemRequest;
import com.lynkattu.shop.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    private final ItemRepository repository;

    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    public List<ItemModel> findAllItems() {
        return repository.findAllItems();
    }

    public Optional<ItemModel> findItemById(String id) {
        return repository.findItemById(id);
    }

    public ItemModel createItem(ItemRequest requestItem) {
        return repository.createItem(requestItem);
    }

}
