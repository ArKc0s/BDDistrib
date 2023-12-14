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

    public long measureTimeForAll() {
        long startTime = System.currentTimeMillis();
        List<Item> items = itemRepository.findAll();

        long endTime = System.currentTimeMillis();
        return (endTime - startTime);
    }
    public long measureTimeForFr() {
        long startTime = System.currentTimeMillis();
        List<Item> items = itemRepository.findByCountry("FR");

        long endTime = System.currentTimeMillis();
        return (endTime - startTime);
    }

    public long measureTimeForGB() {
        long startTime = System.currentTimeMillis();
        List<Item> items = itemRepository.findByCountry("GB");

        long endTime = System.currentTimeMillis();
        return (endTime - startTime);
    }

    public long getRows() {
        return itemRepository.count();
    }

    public long getRowsFr() {
        return itemRepository.findByCountry("FR").size();
    }

    public long getRowsGb() {
        return itemRepository.findByCountry("GB").size();
    }
}
