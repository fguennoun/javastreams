package org.faycal.examples;


import org.faycal.beans.Person;
import org.faycal.mockdata.MockData;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GettingStarted {

    @Test
    public void imperativeApproach() throws IOException {

        List<Person> people = MockData.getPeople();
        List<Person> youngPeople = new ArrayList<>();
        int limit = 10;
        int counter = 0;
        for (Person person : people) {
            if (person.getAge() <= 18) {
                youngPeople.add(person);
                counter++;
                if (counter == limit) {
                    break;
                }
            }
        }
        youngPeople.forEach(System.out::println);
    }

    @Test
    public void functionalApproach() throws IOException {
        List<Person> people = MockData.getPeople();
        List<Person> youngPeople = people.stream()
                .filter(p -> p.getAge() <= 18)
                .limit(10)
                .toList();
        youngPeople.forEach(System.out::println);
    }
}
