import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

class Employee {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
public class Test11 {

    public static void main(String[] args) {
        Employee e1 = new Employee();
        e1.setUsername("Sachin");
        Employee e2 = new Employee();
        e2.setUsername("Tendulkar");
        Employee e3 = new Employee();
        e3.setUsername("Virat");
        List<Employee> list = new ArrayList<>();
        list.add(e1);
        list.add(e2);
        list.add(e3);

        //sort based on length

        List<Employee> collect = list.stream().sorted((emp1, emp2) -> Integer.compare(emp1.getUsername().length(), emp2.getUsername().length()))
                .collect(Collectors.toList());

    }



    //delete from table duplicate
/*
WITH CTE AS (
    SELECT
        *,
        ROW_NUMBER() OVER (PARTITION BY column1, column2, column3 ORDER BY id) AS row_num
    FROM
        your_table
)
DELETE FROM your_table
WHERE id IN (
    SELECT id
    FROM CTE
    WHERE row_num > 1
);
 */

}
