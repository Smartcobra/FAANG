import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RemoveDuplicateConvertToUppercase {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("a");
        list.add("c");
        list.add(null);

        list.stream().distinct()
                .filter(x->x!=null)  //removing null   ---intermidiate
                .map(y->y.toUpperCase())  //converting to uppercase --intermidiate
                .sorted()  //sorting --intermidiate
                .forEach((x)->{
                    System.out.println(x);  //printing
                });


        list.stream().distinct()
                .filter(Objects::nonNull)
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
    }
}
