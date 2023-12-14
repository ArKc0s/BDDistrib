package com.example.bddistrib.service;

import com.example.bddistrib.repository.ItemRepository;
import com.example.bddistrib.model.Item;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Service
public class CsvImportService {

    @Autowired
    private ItemRepository itemRepository;

    public void importerCSV(String cheminFichier) {
        try {
            // Créer un objet FileReader
            FileReader fileReader = new FileReader(cheminFichier);

            // Initialiser un CSVReader
            CSVReader csvReader = new CSVReaderBuilder(fileReader)
                    .withSkipLines(1) // Sauter l'en-tête si nécessaire
                    .withCSVParser(new com.opencsv.CSVParserBuilder().withSeparator(';').build())
                    .build();

            // Lire toutes les lignes
            List<String[]> allData = csvReader.readAll();

            // Parcourir les lignes
            for (String[] row : allData) {
                // Créer un objet Utilisateur à partir de la ligne

                Item item = new Item();
                item.setReference(row[0]);
                item.setCurrency(row[1]);
                item.setPrice(Double.parseDouble(row[2]));
                item.setCountry(row[3]);

                // Enregistrer l'utilisateur dans MongoDB
                itemRepository.save(item);
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
            // Gérer les exceptions ici
        }
    }
}

