package main.service;

import main.Person;
import main.dao.Dao;

import java.util.ArrayList;
import java.util.List;

public class PersonServiceAverageWithStream extends PersonService implements IPersonServiceAverage {

    public PersonServiceAverageWithStream(Dao<Person> dao) {
        super(dao);
    }

    public int averageAgeOfSurvivingWomen () {
        List<Person> personList = dao.getAll();
        double result =  personList.stream()
                .filter(x -> x.getSex().equals("female") && x.getSurvived() == 1)
                .mapToDouble(Person::getAge)
                .average()
                .orElse(0);
        return (int)Math.round(result);
    }

    public int averageAgeOfDrownedMen () {
        List<Person> personList = dao.getAll();
        double result = personList.stream()
                .filter(x -> x.getSex().equals("male") && x.getSurvived() == 0)
                .mapToDouble(Person::getAge)
                .average()
                .orElse(0);
        return (int)Math.round(result);
    }
}
