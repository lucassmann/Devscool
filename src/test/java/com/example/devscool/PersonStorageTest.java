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
//    private  final Person zezinho = new Person("Zezinho", 12);
//    private  final Person luizinho = new Person("Luizinho", 80);

//    @BeforeEach
//    public void setup(){
//        inMemoryPersonStorage = new InMemoryPersonStorage();
//    }

    @Test
    public void getAllIsEmpty_returnsTrue(){
        Assertions.assertThat(inMemoryPersonStorage.getAll().isEmpty());
    }

    @Test
    public void whenAddOnePersonThenGetAllSize_returnsOne(){
        inMemoryPersonStorage.add(huguinho);
        Assertions.assertThat(inMemoryPersonStorage.getAll().size()).isEqualTo(1);
    }

    @Test
    public void whenAddAPersonThenGetAllThenContainsSamePerson(){
        inMemoryPersonStorage.add(huguinho);
        Assertions.assertThat(inMemoryPersonStorage.getAll().contains(huguinho));
    }


}
