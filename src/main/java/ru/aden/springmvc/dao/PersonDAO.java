package ru.aden.springmvc.dao;

import org.springframework.stereotype.Component;
import ru.aden.springmvc.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private List<Person> people;
    private static int peopleCount;

    {
        people = new ArrayList<>();
        people.add(new Person(++peopleCount,"Tom"));
        people.add(new Person(++peopleCount, "Jerry"));
        people.add(new Person(++peopleCount,"Steve"));
        people.add(new Person(++peopleCount,"George"));
    }

    public List<Person> index(){
        return people;
    }

    public  Person show(int id){
        return people.stream().filter(person -> person.getId() == id)
                .findAny().orElse(null);
    }
}
