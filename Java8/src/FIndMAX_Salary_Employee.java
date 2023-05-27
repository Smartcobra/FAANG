import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class Employee{
    String name;
    int age;
    double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}


public class FIndMAX_Salary_Employee {

    static List<Employee> employeeList
            = Arrays.asList(new Employee("Tom Jones", 45, 15000.00),
            new Employee("Tom Jones", 45, 7000.00),
            new Employee("Ethan Hardy", 65, 8000.00),
            new Employee("Nancy Smith", 22, 10000.00),
            new Employee("Deborah Sprightly", 29, 9000.00));


    public static void main(String[] args) {
        Optional<Employee> maxSalaryEmp = employeeList.stream().max(Comparator.comparing(Employee::getSalary));

        System.out.println("Employee with max salary:"
                + (maxSalaryEmp.isPresent()? maxSalaryEmp.get():"Not Applicable"));


        Optional<Employee> minAge = employeeList.stream().min(Comparator.comparing(Employee::getAge));

        System.out.println("Employee with min age:"
                + (minAge.isPresent()? minAge.get():"Not Applicable"));



    }
}
