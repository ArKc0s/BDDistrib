package com.example.bddistrib.service;

import com.example.bddistrib.model.Item;
import com.example.bddistrib.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeMeasuringService {

    @Autowired
    private ItemRepository itemRepository;

    public long measureTime() {
        long startTime = System.currentTimeMillis();
        List<Item> items = itemRepository.findAll();

        long endTime = System.currentTimeMillis();
        return (endTime - startTime);
    }
}
