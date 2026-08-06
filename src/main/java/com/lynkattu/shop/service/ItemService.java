package com.lynkattu.shop.service;


import com.lynkattu.shop.enums.ItemCategory;
import com.lynkattu.shop.model.ItemModel;
import com.lynkattu.shop.model.ItemRequest;
import com.lynkattu.shop.repository.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    private static final Logger log = LoggerFactory.getLogger(ItemService.class);
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

    public Optional<ItemModel> deleteItem(String id) {
        return repository.deleteItem(id);
    }

    public List<ItemModel> searchItem(String name, ItemCategory itemCategory) {
        if (name != null && itemCategory != null) {
            return repository.getItemsByNameAndCategory(name, itemCategory);
        }
        if (name != null) {
            return repository.findItemByName(name);
        }
        if (itemCategory != null) {
            return repository.findItemsByCategory(itemCategory);
        }
        return repository.findAllItems();
    }

}
