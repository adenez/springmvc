package ru.aden.springmvc.dao;

import org.springframework.stereotype.Component;
import ru.aden.springmvc.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Tom", 25, "somemail@mail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Bob", 35, "somemail2@mail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Mike", 45, "somemail3@mail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Katy", 55, "somemail4@mail.com"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);

        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
