package com.example.devscool;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class InMemoryPersonStorage implements PersonStorage{
    private ArrayList<Person> people;

    public InMemoryPersonStorage(){
        this.people = new ArrayList<>();
    }

    @Override
    public void add(Person person) {
        people.add(person);
    }

    @Override
    public List<Person> getAll() {
        return people;
    }

    public String toString(){
        return people.stream()
                .map(Person::toString)
                .collect(Collectors.joining(", \n"));
    }
}
