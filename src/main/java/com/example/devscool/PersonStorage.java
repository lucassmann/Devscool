package com.example.devscool;

import java.util.List;

public interface PersonStorage {

    void add(Person pessoa);

    List<Person> getAll();

    String toString();

}
