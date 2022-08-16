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
        try{
            return personStorage.getAll().stream()
                    .sorted(Comparator.comparing(Person::getName))
                    .collect(Collectors.toList());
        }
        catch (NullPointerException e){
            return this.personStorage.getAll();
        }
    }

    public List<Person> sortByAge(){
        try {
            return personStorage.getAll()
                    .stream()
                    .sorted(Comparator.comparing(Person::getAge))
                    .collect(Collectors.toList());
        }
        catch (NullPointerException e){
            return this.personStorage.getAll();
        }
    }

    public List<Person> getChildren(){
        try {
            return personStorage.getAll().stream()
                    .filter(person -> (person.getAge() < 12))
                    .collect(Collectors.toList());
        }
        catch (NullPointerException e){
            return this.personStorage.getAll();
        }

    }

    public List<Person> getTeenagers(){
        try {
            return personStorage.getAll().stream()
                    .filter(person -> (person.getAge() >= 12 && person.getAge() < 20))
                    .collect(Collectors.toList());
        }
        catch (NullPointerException e){
            return this.personStorage.getAll();
        }
    }

    public List<Person> getAdults(){
        try {
            return personStorage.getAll().stream()
                    .filter(person -> (person.getAge() >= 20 && person.getAge() < 65))
                    .collect(Collectors.toList());
        }
        catch (NullPointerException e){
            return this.personStorage.getAll();
        }
    }

    public List<Person> getElderly(){
        try {
            return personStorage.getAll().stream()
                    .filter(person -> (person.getAge() > 65))
                    .collect(Collectors.toList());
        }
        catch (NullPointerException e){
            return this.personStorage.getAll();
        }
    }
}
