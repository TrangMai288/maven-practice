package org.example.practice2.starwar;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Luke Skywalker", 172, 77, "blond", "fair", "blue", "19BBY", "male");
        Person person2 = new Person("Darth Vader", 202, 136, "none", "white", "yellow", "41.9BBY", "male");
        Person person3 = new Person("Leia Organa", 150, 49, "brown", "light", "brown", "19BBY", "female");
        Person person4 = new Person("Owen Lars", 178, 120, "brown, grey", "light", "blue", "52BBY", "male");
        Person person5 = new Person("Beru Whitesun lars", 165, 75, "brown", "light", "blue", "47BBY", "female");
        Person person6 = new Person("Biggs Darklighter", 183, 84, "black", "light", "brown", "24BBY", "male");
        Person person7 = new Person("Obi-Wan Kenobi", 182, 77, "auburn, white", "fair", "blue-gray", "57BBY", "male");

        List<Person> characters = Arrays.asList(
                person1,
                person2,
                person3,
                person4,
                person5,
                person6,
                person7);
        characters.forEach(person -> person.printInfo());

        // todo: find person that has mass > 100 (1)
        // cach 1:
        List<Person> personHasMassGreater100 = characters
                .stream()
                .filter(person -> person.getMass() > 100)
                .toList();
        // cach 2:
        List<Person> personHasMassLess100 = characters
                .stream()
                .filter(person -> person.getMass() < 100)
                .collect(Collectors.toList());
        personHasMassLess100.forEach(Person::printInfo);

        // todo: total mass of characters (2)
        // cach 1:
        List<Integer> totalMassOfCharacters = characters
                .stream()
                .map(Person::getMass)
                .toList();
        int totalMass1 = 0;
        for (int i = 0; i < totalMassOfCharacters.size(); i++) {
            totalMass1 += totalMassOfCharacters.get(i);
        }
        System.out.printf("Total Mass = %d\n", totalMass1);
        // cach 2:
        Integer totalMass2 = characters
                .stream()
                .mapToInt(Person::getMass)
                .sum();
        System.out.printf("Total Mass = %d\n", totalMass2);

        // todo: total height of characters (3)
        // cach 1:
        Integer totalHeight1 = characters
                .stream()
                .mapToInt(Person::getHeight)
                .sum();
        System.out.printf("Total Height = %d\n", totalHeight1);
        // cach 2: using reduce
        Integer totalHeight2 = characters
                .stream()
                .reduce(0, (height, person) -> height + person.getHeight(), Integer::sum);
        System.out.printf("Total Height = %d\n", totalHeight2);

        // todo: get list name of person (4)
        // cach 1
        List<String> listNameOfPerson1 = characters
                .stream()
                .map(Person::getName)
                .toList();
        listNameOfPerson1.forEach(name -> System.out.println(name));
        // cach 2
        List<String> listNameOfPerson2 = characters
                .stream()
                .map(Person::getName)
                .collect(Collectors.toList());
        listNameOfPerson2.forEach(name -> System.out.println(name));

        // todo: find max mass person (5)
        Person maxMassPerson = characters
                .stream()
                .max(Comparator.comparing(Person::getMass))
                .get();
        maxMassPerson.printInfo();

        // todo: find smallest person (6)
        Person smallestPerson = characters
                .stream()
                .min(Comparator.comparing(Person::getHeight))
                .get();
        smallestPerson.printInfo();

        // todo: sort by name (7)
        // cach 1
        List<Person> personSortByName1 = characters
                .stream()
                .sorted(Comparator.comparing(Person::getName))
                .toList();
        // cach 2
        List<Person> personSortByName2 = characters
                .stream()
                .sorted(Comparator.comparing(Person::getName).reversed())
                .collect(Collectors.toList());
        personSortByName2.forEach(Person::printInfo);

        // todo: sort by mass (8)
        List<Person> personSortByMass = characters
                .stream()
                .sorted(Comparator.comparing(Person::getMass))
                .toList();
        personSortByMass.forEach(Person::printInfo);

    }
}
