import java.util.*;
import java.util.stream.Collectors;

class Employee {
    String name;
    int age;
    double salary;

    String desgn;

    public String getDesgn() {
        return desgn;
    }

    public void setDesgn(String desgn) {
        this.desgn = desgn;
    }

    public Employee(String name, int age, double salary, String desgn) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.desgn = desgn;
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
            = Arrays.asList(new Employee("Tom Jones", 45, 15000.00, "Manager"),
            new Employee("Tom Jones", 45, 7000.00, "Developer"),
            new Employee("Ethan Hardy", 65, 8000.00, "Developer"),
            new Employee("Nancy Smith", 22, 10000.00, "Manager"),
            new Employee("Deborah Sprightly", 29, 9000.00, "Designer"));


    public static void main(String[] args) {
        Optional<Employee> maxSalaryEmp = employeeList.stream().max(Comparator.comparing(Employee::getSalary));

        System.out.println("Employee with max salary:"
                + (maxSalaryEmp.isPresent() ? maxSalaryEmp.get() : "Not Applicable"));


        Optional<Employee> minAge = employeeList.stream().min(Comparator.comparing(Employee::getAge));

        System.out.println("Employee with min age:"
                + (minAge.isPresent() ? minAge.get() : "Not Applicable"));
        //Given List<Employee>, Group them by Designation.
        Map<String, List<Employee>> groupedByDesignation = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDesgn));

        //Given List<Employee>, Get a Map which has Department, and Employee Name drawing highest salary in the department.
        Map<String, String> highestSalaryEmployees = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDesgn,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)),
                                emp -> emp.map(Employee::getName).orElse(null)
                        )
                ));

        //Find the employee with the second highest salary from a List<Employee>
        Optional<Employee> secondHighest =  employeeList.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .distinct() // To avoid duplicates in case of equal salaries
                .skip(1) // Skip the highest salary
                .findFirst(); // Get the second highest salary

    }
}
