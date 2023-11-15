package ait.citizens.dao;

import ait.citizens.model.Person;

import java.util.Comparator;
import java.util.List;

public class CitizensImpl implements Citizens {
    private List<Person> idList;
    private List<Person> lastNameList;
    private List<Person> ageList;
    private static  Comparator<Person> lastNameComparator;
    private static  Comparator<Person> ageComparator;

    @Override
    public boolean add(Person person) {
        return false;
    }
    public CitizensImpl() {

    }
    public CitizensImpl(List<Person> citizens) {

    }

    @Override
    public boolean remove(int id) {
        return false;
    }

    @Override
    public Person find(int id) {
        return null;
    }

    @Override
    public Iterable<Person> find(int minAge, int maxAge) {
        return null;
    }

    @Override
    public Iterable<Person> find(String lastName) {
        return null;
    }

    @Override
    public Iterable<Person> getAllPersonsSortedById() {
        return null;
    }

    @Override
    public Iterable<Person> getAllPersonsSortedByLastName() {
        return null;
    }

    @Override
    public Iterable<Person> getAllPersonsSortedByAge() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
