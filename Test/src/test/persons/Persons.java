package test.persons;

public class Persons implements Comparable{
    String name;

    public Persons(String name){
        this.name=name;

    }
    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
