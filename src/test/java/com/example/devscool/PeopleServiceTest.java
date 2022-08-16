package com.example.devscool;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

@SpringBootTest
public class PeopleServiceTest {

    @MockBean
    PersonStorage mockPersonStorage;

    @Autowired
    PeopleService peopleService = new PeopleService(mockPersonStorage);

    public final Person testPersonAge1 = new Person("testPersonAge1", 1);
    public final Person testPersonAge12 = new Person("testPersonAge12", 12);
    public final Person testPersonAge20 = new Person("testPersonAge20", 20);
    public final Person testPersonAge60 = new Person("testPersonAge60", 60);
    public final Person testPersonAge80 = new Person("testPersonAge80", 80);


    @Test
    void givenEmptyPersonStorageMock_WhenSortByName_ThenEmptyList(){
        ArrayList<Person> people = new ArrayList<>();
        Mockito.when(mockPersonStorage.getAll()).thenReturn(people);
        Assertions.assertThat(peopleService.sortByName()).isEmpty();
    }

    @Test
    void givenUnsortedPersonStorageMock_WhenSortByName_ThenSortedList(){
        Mockito.when(mockPersonStorage.getAll()).thenReturn(Arrays.asList(testPersonAge80, testPersonAge12, testPersonAge1, testPersonAge60, testPersonAge20));
        Assertions.assertThat(peopleService.sortByName()).isEqualTo(Arrays.asList(testPersonAge1,testPersonAge12,testPersonAge20,testPersonAge60,testPersonAge80));

    }

    @Test
    void givenUnsortedPersonStorageMock_WhenSortByAge_ThenSortedList(){
        Mockito.when(mockPersonStorage.getAll()).thenReturn(Arrays.asList(testPersonAge80, testPersonAge12, testPersonAge1, testPersonAge60, testPersonAge20));
        Assertions.assertThat(peopleService.sortByAge()).isEqualTo(Arrays.asList(testPersonAge1,testPersonAge12,testPersonAge20,testPersonAge60,testPersonAge80));

    }


    @Test
    void givenPersonStorageMockContainingOneChild_WhenGetChildren_ThenOneChildList(){
        Mockito.when(mockPersonStorage.getAll()).thenReturn(Arrays.asList(testPersonAge1,testPersonAge12, testPersonAge20, testPersonAge60, testPersonAge80));
        Assertions.assertThat(peopleService.getChildren()).isEqualTo(Collections.singletonList(testPersonAge1));
    }

    @Test
    void givenPersonStorageMockContainingOneTeenager_WhenGetTeenager_ThenOneTeenagerList(){
        Mockito.when(mockPersonStorage.getAll()).thenReturn(Arrays.asList(testPersonAge1,testPersonAge12, testPersonAge20, testPersonAge60, testPersonAge80));
        Assertions.assertThat(peopleService.getTeenagers()).isEqualTo(Collections.singletonList(testPersonAge12));
    }

    @Test
    void givenPersonStorageMockContainingTwoAdults_WhenGetAdult_ThenTwoAdultsList(){
        Mockito.when(mockPersonStorage.getAll()).thenReturn(Arrays.asList(testPersonAge1,testPersonAge12, testPersonAge20, testPersonAge60, testPersonAge80));
        Assertions.assertThat(peopleService.getAdults()).isEqualTo(Arrays.asList(testPersonAge20, testPersonAge60));
    }

    @Test
    void givenPersonStorageMockContainingOneElderly_WhenGetElderly_ThenOneElderlyList(){
        Mockito.when(mockPersonStorage.getAll()).thenReturn(Arrays.asList(testPersonAge1,testPersonAge12, testPersonAge20, testPersonAge60, testPersonAge80));
        Assertions.assertThat(peopleService.getElderly()).isEqualTo(Collections.singletonList(testPersonAge80));
    }



}