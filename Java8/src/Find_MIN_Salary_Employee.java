import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Find_MIN_Salary_Employee {

    static List<Employee> employeeList
            = Arrays.asList(new Employee("Tom Jones", 45, 15000.00),
            new Employee("Tom Jones", 45, 7000.00),
            new Employee("Ethan Hardy", 65, 8000.00),
            new Employee("Nancy Smith", 22, 10000.00),
            new Employee("Deborah Sprightly", 29, 9000.00));


        public static void main(String[] args) {
            Optional<Employee> minSalaryEmp = employeeList.stream().min(Comparator.comparing(Employee::getSalary));

            System.out.println("Employee with max salary:"
                    + (minSalaryEmp.isPresent()? minSalaryEmp.get():"Not Applicable"));


            Optional<Employee> minAge = employeeList.stream().min(Comparator.comparing(Employee::getAge));

            System.out.println("Employee with min age:"
                    + (minAge.isPresent()? minAge.get():"Not Applicable"));



        }
}
