package org.faycal.examples;

import org.faycal.beans.Car;
import org.faycal.beans.Person;
import org.faycal.mockdata.MockData;
import org.junit.Test;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sorting {

    @Test
    public void sortingSteamOfElements() throws IOException {
        List<Person> people = MockData.getPeople();
        List<String> sorted = people.stream()
                .map(Person::getFirstName)
//                .sorted(Comparator.comparing(s -> s.toLowerCase()))
                .sorted()
//                .limit(10)
                .collect(Collectors.toList());
        sorted.forEach(System.out::println);
    }

    @Test
    public void sortingSteamOfElementsReverse() throws IOException {
        List<Person> people = MockData.getPeople();

        List<String> sorted = people.stream()
                .map(Person::getFirstName)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        sorted.forEach(System.out::println);
    }

    @Test
    public void sortingSteamOfObjets0() throws IOException {
        List<Person> people = MockData.getPeople();
        List<Person> sort = people.stream()
                .sorted(Comparator.comparing(Person::getFirstName))
                .collect(Collectors.toList());
        sort.forEach(System.out::println);
    }

    @Test
    public void sortingSteamOfObjets() throws IOException {
        List<Person> people = MockData.getPeople();

        Comparator<Person> comparing = Comparator
                .comparing(Person::getEmail)
                .reversed()
                .thenComparing(Person::getFirstName);

        List<Person> sort = people.stream()
                .sorted(comparing)
                .collect(Collectors.toList());
        sort.forEach(System.out::println);
    }

    @Test
    public void topTenMostExpensiveBlueCars() throws IOException {
        List<Car> cars = MockData.getCars();
        List<Car> topTen = cars.stream()
                .filter(car -> car.getColor().equalsIgnoreCase("blue"))
                .sorted(Comparator.comparing(Car::getPrice).reversed())
                .limit(10)
                .collect(Collectors.toList());
        topTen.forEach(System.out::println);
    }
}
