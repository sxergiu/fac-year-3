package org.loose.good.refactoring.student;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ManagerTest {

    private Manager manager;

    @Before
    public void setUp() {
        manager = new Manager();
    }

    @Test
    public void getStudentNames() {
        List<String> studentNames = manager.getPeopleNames(getTestPeople());

        List<String> expectedNames = Arrays.asList("Amy Adams", "Ashley Cooper", "Daniel Foster", "James Close",
                "James Davies", "Jane Smith", "Margret Flower", "Samantha Dish", "Tom Clark");

        assertEquals(expectedNames, studentNames);
    }

    private List<Person> getTestPeople() {
        return Arrays.asList(
                new Person("John", "Doe", 17, Status.SINGLE),
                new Person("Jane", "Smith", 29, Status.MARRIED),
                new Person("Samantha", "Dish", 18, Status.SINGLE),
                new Person("Ashley", "Cooper", 21, Status.MARRIED),
                new Person("Amy", "Adams", 29, Status.DIVORCED),
                new Person("James", "Davies", 50, Status.MARRIED),
                new Person("Tom", "Clark", 39, Status.SINGLE),
                new Person("Margret", "Flower", 49, Status.WIDOW),
                new Person("John", "Ford", 12, Status.SINGLE),
                new Person("Daniel", "Foster", 65, Status.DIVORCED),
                new Person("Ashley", "Young", 3, Status.SINGLE),
                new Person("James", "Close", 34, Status.MARRIED)
        );
    }
}