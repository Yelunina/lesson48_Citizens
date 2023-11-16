package ait.citizens.test;

import ait.citizens.dao.Citizens;
import ait.citizens.dao.CitizensImpl;
import ait.citizens.model.Person;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CitizensImplTest {
    private Citizens citizens;
    static final LocalDate now = LocalDate.now();

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        citizens = new CitizensImpl(List.of(
                new Person(1, "Ivan", "Ivanov", now.minusYears(10)),
                new Person(2, "Petr", "Petrov", now.minusYears(20)),
                new Person(3, "Nikolay", "Nikolaev", now.minusYears(20)),
                new Person(4, "Misha", "Mihailov", now.minusYears(30)),
                new Person(5, "Yriy", "Mihailov", now.minusYears(40))
        ));
    }

    @Test
    void CitizensImpl() {
        //TODO
        citizens = new CitizensImpl(
                List.of(new Person(1, "Ivan", "Ivanov", now.minusYears(10)),
                        new Person(1, "Ivan", "Ivanov", now.minusYears(10))));
        assertEquals(1, citizens.size());
    }

    @Test
    void CitizensImpl(List<Person> citizens) {
        //TODO

    }

    @org.junit.jupiter.api.Test
    void add() {
        assertFalse(citizens.add(null));
        assertFalse(citizens.add(new Person(2, "Petr", "Petrov", now.minusYears(20))));
        assertEquals(5, citizens.size());
        assertTrue(citizens.add(new Person(6, "Ivan", "Mihailov", now.minusYears(50))));
        assertEquals(6, citizens.size());
    }

    @org.junit.jupiter.api.Test
    void remove() {
        assertFalse(citizens.remove(6));
        assertEquals(5, citizens.size());
        assertTrue(citizens.remove(1));
        assertEquals(4, citizens.size());
    }

    @org.junit.jupiter.api.Test
    void findById() {
        Person person = citizens.find(2);
        assertEquals(2, person.getId());
        assertEquals("Petr", person.getFirstName());
        assertEquals("Petrov", person.getLastName());
        assertEquals(20, person.getAge());
        assertNull(citizens.find(6));
    }

    @org.junit.jupiter.api.Test
    void testFindByMinAgeMaxAge() {
        Iterable<Person> persons = citizens.find(20, 10);
        List<Person> actual = new ArrayList<>();
        for (Person person : persons) {
            actual.add(person);
        }
        Collections.sort(actual);
        List<Person> expected = List.of(
                new Person(1, "Ivan", "Ivanov", now.minusYears(10)),
                new Person(2, "Petr", "Petrov", now.minusYears(20)),
                new Person(3, "Nikolay", "Nikolaev", now.minusYears(20))
        );
        assertIterableEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void testLastName() {
        Iterable<Person> persons = citizens.find("Mihailov");
        List<Person> actual = new ArrayList<>();
        for (Person person : persons) {
            actual.add(person);
        }
        Collections.sort(actual);
        List<Person> expected = List.of(
                new Person(4, "Peter", "Mihailov", now.minusYears(30)),
                new Person(5, "Mary", "Mihailov", now.minusYears(40))
        );
        assertIterableEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void getAllPersonsSortedById() {
        Iterable<Person> persons = citizens.getAllPersonsSortedById();
        int id = -1;
        int count = 0;
        for (Person person : persons) {
            count++;
            assertTrue(person.getId() > id);
            id = person.getId();
        }
        assertEquals(citizens.size(), count);
    }

    @org.junit.jupiter.api.Test
    void getAllPersonsSortedByLastName() {
        Iterable<Person> persons = citizens.getAllPersonsSortedByLastName();
        String lastName = "";
        int count = 0;
        for (Person person : persons) {
            count++;
            assertTrue(person.getLastName().compareTo(lastName) >= 0);
            lastName = person.getLastName();
        }
        assertEquals(citizens.size(), count);
    }

    @org.junit.jupiter.api.Test
    void getAllPersonsSortedByAge() {
        Iterable<Person> persons = citizens.getAllPersonsSortedByAge();
        int age = -1;
        int count = 0;
        for (Person person : persons) {
            count++;
            assertTrue(person.getAge() >= age);
            age = person.getAge();
        }
        assertEquals(citizens.size(), count);
    }

    @org.junit.jupiter.api.Test
    void size() {
        assertEquals(5, citizens.size());
    }
}