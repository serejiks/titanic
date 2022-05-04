package main;

import main.dao.Dao;
import main.dao.MemoryPersonDao;
import main.service.IPersonServiceAverage;
import main.service.PersonServiceAverage;
import main.service.PersonServiceAverageWithStream;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String file = "src\\Sergey Tarasov - train.csv";
        Dao<Person> personDao = MemoryPersonDao.getInstance();
        PersonParserFileCSV parser = new PersonParserFileCSV();
        IPersonServiceAverage service = new PersonServiceAverage(personDao);
        parser.parsing(file, personDao);
        int averageAgeOfSurvivingWomen = service.averageAgeOfSurvivingWomen();
        int averageAgeOfDrownedMen = service.averageAgeOfDrownedMen();

        Map<Integer, Integer> map = new HashMap<>();
        personDao.getAll().forEach(x -> {
            map.compute(x.getName().length(), (k, v) -> v == null ? 1 : ++v);
        });

        for (Integer key : map.keySet()) {
            System.out.println("Количество символов в имени = " + key + ", количество таких имен = " + map.get(key));
        }

        System.out.println("Средний возраст выживших женщин: " + averageAgeOfSurvivingWomen);
        System.out.println("Средний возраст утонувших мужчин: " + averageAgeOfDrownedMen);
    }
}
