package main;

import main.dao.Dao;
import main.dao.MemoryPersonDao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PersonParserFileCSV {

    public void parsing(String fileName, Dao<Person> personDao) {
        String line = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String name = line.substring(line.indexOf(",\"") + 2, line.indexOf("\","));
                String[] row = line.replace(",\""+name+"\"", "").split(",");
                row[4] = "".equals(row[4]) ? String.valueOf(0) : row[4];
                personDao.save(new Person(name, Double.parseDouble(row[4]), Integer.parseInt(row[1]), row[3]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
