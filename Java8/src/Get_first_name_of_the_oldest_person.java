import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Get_first_name_of_the_oldest_person {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 40),
                new Person("David", 35)
        );

        Optional<String> oldestPersonFirstName = people.stream()
                .max(Comparator.comparingInt(Person::getAge)) // Find the oldest person
                .map(Person::getFirstName); // Extract the first name

        oldestPersonFirstName.ifPresent(firstName ->
                System.out.println("First name of the oldest person: " + firstName));
    }

    static class Person {
        private String firstName;
        private int age;

        public Person(String firstName, int age) {
            this.firstName = firstName;
            this.age = age;
        }

        public String getFirstName() {
            return firstName;
        }

        public int getAge() {
            return age;
        }
    }
}
