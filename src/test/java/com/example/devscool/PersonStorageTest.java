package com.example.devscool;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PersonStorageTest {

    @Autowired
    private InMemoryPersonStorage inMemoryPersonStorage;
    private final Person huguinho = new Person("Huguinho", 1);

    @Test
    void getAllIsEmpty_returnsTrue(){
        Assertions.assertThat(inMemoryPersonStorage.getAll().isEmpty());
    }

    @Test
    void whenAddOnePersonThenGetAllSize_returnsOne(){
        inMemoryPersonStorage.add(huguinho);
        Assertions.assertThat(inMemoryPersonStorage.getAll().size()).isEqualTo(1);
    }

    @Test
    void whenAddAPersonThenGetAllThenContainsSamePerson(){
        inMemoryPersonStorage.add(huguinho);
        Assertions.assertThat(inMemoryPersonStorage.getAll().contains(huguinho));
    }


}
