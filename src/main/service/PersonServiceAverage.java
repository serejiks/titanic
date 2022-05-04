package main.service;

import main.Person;
import main.dao.Dao;

import java.util.ArrayList;
import java.util.List;

public class PersonServiceAverage extends PersonService implements IPersonServiceAverage {

    public PersonServiceAverage(Dao<Person> dao) {
        super(dao);
    }

    public int averageAgeOfSurvivingWomen () {
        int count = 0;
        double sumAge = 0;
        List<Person> personList = dao.getAll();
        for (Person person : personList) {
            if ("female".equals(person.getSex()) && person.getSurvived() == 1) {
                count++;
                sumAge += person.getAge();
            }
        }
        return (int)(sumAge / count);
    }

    public int averageAgeOfDrownedMen () {
        int count = 0;
        double sumAge = 0;
        List<Person> personList = dao.getAll();
        for (Person person : personList) {
            if ("male".equals(person.getSex()) && person.getSurvived() == 0) {
                count++;
                sumAge += person.getAge();
            }
        }
        return (int)(sumAge / count);
    }
}
