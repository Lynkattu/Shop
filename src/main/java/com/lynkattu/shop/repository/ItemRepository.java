package com.lynkattu.shop.repository;

import com.lynkattu.shop.model.ItemModel;
import com.lynkattu.shop.model.ItemRequest;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ItemRepository {

    private final JdbcClient jdbc;

    public ItemRepository(JdbcClient jdbc) {
        this.jdbc = jdbc;
    }

    //----------------------------------------------------------------------------------------------------------------
    public List<ItemModel> findAllItems() {
        return jdbc.sql("""
                SELECT * FROM items;
                """
        ).query(ItemModel.class).list();
    }

    public Optional<ItemModel> findItemById(String id) {
        return jdbc.sql(
            """
            SELECT * FROM items
            WHERE id = :id
            """)
                .params("id", id)
                .query(ItemModel.class)
                .optional();
    }

    public Optional<ItemModel> createItem(ItemRequest item) {
        String id = UUID.randomUUID().toString();

        jdbc.sql("""
            INSERT INTO items (
                id,
                name,
                price,
                description,
                item_category,
                created_at,
                updated_at
            )
            VALUES (
                :id,
                :name,
                :price,
                :description,
                :itemCategory,
                NOW(),
                NOW()
            )
            """)
                .param("id", id)
                .param("name", item.name())
                .param("price", item.price())
                .param("description", item.description())
                .param("itemCategory", item.itemCategory())
                .update();

        return findItemById(id);
    }

}
