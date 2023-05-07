import java.util.ArrayList;
import java.util.List;

public class TestMe {

    class Emp{
        public int id;
    }
    public static void main(String[] args) {
        List<Emp> empList = new ArrayList<>();
        System.out.println(empList.size());
        empList = null;
        System.out.println(empList.size());
    }
}
