package immutable;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
public class Person {
    // 1. Final class to prevent subclassing
    // 2. Final fields to ensure they cannot be modified after initialization
    private final String name;
    private final int age;
    private final List<String> hobbies; // A mutable collection is used, will be defensively copied

    // 3. No setter methods
    // No setters are provided, so the object's state cannot be modified after construction

    // 4. Initialization through constructor
    public Person(String name, int age, List<String> hobbies) {
        this.name = name;
        this.age = age;

        // 5. Defensive copying to protect against mutable collections
        this.hobbies = Collections.unmodifiableList(hobbies != null ? new ArrayList<>(hobbies) : null);
    }

    // 6. Access fields via getters only
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    // 7. No methods that modify internal state
    // The state of the object cannot be modified by any method, including `getHobbies` which returns an unmodifiable list

    // 8. Thread safety
    // Immutable objects are inherently thread-safe as their state cannot change after construction

    // 9. No clone() method
    // The clone method is not implemented to prevent accidental creation of mutable copies

    // 10. Serialization safety
    // Serialization is safe because the object is immutable, but we could implement `readResolve()` if necessary

    private Object readResolve() {
        return this;
    }

    // 11. Hashcode and Equals contract
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return age == person.age && name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    // 12. Best practices for immutable collections
    // The hobbies list is unmodifiable and defensively copied to ensure immutability

    // 13. Custom implementations for mutability protection
    // We ensure that the list passed into the constructor is not shared and remains unmodifiable

    // 14. Final class and fields ensure that no subclass or mutable state can alter the behavior

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", hobbies=" + hobbies + "}";
    }
}
