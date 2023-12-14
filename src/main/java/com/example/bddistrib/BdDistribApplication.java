package com.example.bddistrib;

import com.example.bddistrib.repository.ItemRepository;
import com.example.bddistrib.service.CsvImportService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class BdDistribApplication implements CommandLineRunner {

    @Autowired
    private CsvImportService csvImportService;
    @Autowired
    private ItemRepository itemRepository;

    public static void main(String[] args) {
        SpringApplication.run(BdDistribApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        if(itemRepository.count() == 0) {
            System.out.println("Importing CSV data");
            csvImportService.importerCSV("src/main/resources/products.csv");
        }
    }
}


