package test.persons;

import java.util.HashSet;
import java.util.Set;

public class Demo {
    public static void main(String[] args) {
        Persons p1= new Persons("ABC");
        Persons p2= new Persons("BCD");
        Persons p3= new Persons("DEF");
        Persons p4= new Persons("ABC");

        Set<Persons> t= new HashSet<>();
        t.add(p1);
        t.add(p2);
        t.add(p3);
        t.add(p4);

        System.out.println(t.size());

    }
}
