package com.example.devscool;

import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class PeopleService {
    private PersonStorage personStorage;

    public PeopleService(PersonStorage personStorage){
        this.personStorage = personStorage;
    }

    public List<Person> sortByName(){
        return personStorage.getAll().stream()
                .sorted(Comparator.comparing(Person::getName))
                .collect(Collectors.toList());
    }

    public List<Person> sortByAge(){
        return personStorage.getAll().stream()
                .sorted(Comparator.comparing(Person::getAge))
                .collect(Collectors.toList());
    }

    public List<Person> getChildren(){
        return personStorage.getAll().stream()
                .filter(person -> (person.getAge() < 12))
                .collect(Collectors.toList());
    }

    public List<Person> getTeenagers(){
        return personStorage.getAll().stream()
                .filter(person -> (person.getAge() >= 12 && person.getAge() < 20))
                .collect(Collectors.toList());
    }

    public List<Person> getAdults(){
        return personStorage.getAll().stream()
                .filter(person -> (person.getAge() >= 20 && person.getAge() < 65))
                .collect(Collectors.toList());
    }

    public List<Person> getElderly(){
        return personStorage.getAll().stream()
                .filter(person -> (person.getAge() > 65))
                .collect(Collectors.toList());
    }
}
