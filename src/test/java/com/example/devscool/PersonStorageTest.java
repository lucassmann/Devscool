package com.example.devscool;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PersonStorageTest {

    @Autowired
    private InMemoryPersonStorage inMemoryPersonStorage;
    private final Person testPerson1 = new Person("testPerson1", 1);

    @Test
    void getAllIsEmpty_returnsTrue(){
        Assertions.assertThat(inMemoryPersonStorage.getAll()).isEmpty();
    }

    @Test
    void whenAddOnePersonThenGetAllSize_returnsOne(){
        inMemoryPersonStorage.add(testPerson1);
        Assertions.assertThat(inMemoryPersonStorage.getAll().size()).isEqualTo(1);
    }

    @Test
    void whenAddAPersonThenGetAllThenContainsSamePerson(){
        inMemoryPersonStorage.add(testPerson1);
        Assertions.assertThat(inMemoryPersonStorage.getAll()).contains(testPerson1);
    }


}
