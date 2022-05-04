package main.service;

import main.Person;
import main.dao.Dao;

import java.util.ArrayList;

public abstract class PersonService {
    Dao dao;

    public PersonService(Dao dao) {
        this.dao = dao;
    }
}
