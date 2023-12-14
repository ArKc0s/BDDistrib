package com.example.bddistrib.repository;

import com.example.bddistrib.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends MongoRepository<Item, String> {
    Item findByReference(String reference);
    List<Item> findByCountry(String country);
    List<Item> findByCurrency(String currency);
    List<Item> findByPrice(double price);
}
