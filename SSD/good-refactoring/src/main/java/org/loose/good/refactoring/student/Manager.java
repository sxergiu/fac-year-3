package org.loose.good.refactoring.student;

import java.util.ArrayList;
import java.util.List;

public class Manager {

    public List<String> getPeopleNames(List<Person> people) {

        ArrayList<Person> personList = GetOveragePeople(people);

        ArrayList<String> stringList = GetPeopleNames(personList);

        OrderNamesAlphabetically(stringList);

        PrintNames(stringList);

        return stringList;
    }

    private static void PrintNames(ArrayList<String> stringList) {
        for (String s : stringList) System.out.println(s);
    }

    private static void OrderNamesAlphabetically(ArrayList<String> stringList) {
        for (int i = 0; i < stringList.size(); i++) {
            for (int j = i; j < stringList.size(); j++) {
                if (stringList.get(i).compareToIgnoreCase(stringList.get(j)) > 0) {
                    String aux = stringList.get(j);
                    stringList.set(j, stringList.get(i));
                    stringList.set(i, aux);
                }
            }
        }
    }

    private static ArrayList<String> GetPeopleNames(ArrayList<Person> personList) {
        ArrayList<String> stringList = new ArrayList<>();
        for (int i = 0; i < personList.size(); i++) {
            Person p = personList.get(i);
            String s1 = p.getFirstName() + " " + p.getLastName();
            stringList.add(s1);
        }
        return stringList;
    }

    private static ArrayList<Person> GetOveragePeople(List<Person> people) {
        ArrayList<Person> personList = new ArrayList<>();
        for (Person person : people) {
            int x = person.getAge();
            if (x >= 18) {
                personList.add(person);
            }
        }
        return personList;
    }
}