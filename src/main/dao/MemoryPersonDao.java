package main.dao;

import main.Person;

import java.util.ArrayList;
import java.util.List;

public class MemoryPersonDao implements Dao<Person> {
    private List<Person> personList = new ArrayList<>();
    private static MemoryPersonDao instance;

    private MemoryPersonDao(){

    }

    public static MemoryPersonDao getInstance() {
        if (instance == null) {        
            instance = new MemoryPersonDao();
        }
        return instance;
    }

    @Override
    public List<Person> getAll() {
        return new ArrayList<>(personList);
    }

    @Override
    public void save(Person person) {
        personList.add(person);
    }
}
