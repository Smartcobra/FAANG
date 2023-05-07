import java.util.Arrays;
import java.util.Comparator;

public class ArraySortTest {

    public static void main(String[] args) {
        int[][] boxTypes = {{10, 2}, {5, 3}, {15, 5}, {7, 7}, {6, 1}, {18, 4}, {3, 1}};

        Arrays.sort(boxTypes, new Comparator<int[]>() {
                    @Override
                    public int compare(final int[] entry1, final int[] entry2) {
                        if (entry1[0]/entry1[1] < entry2[0]/entry2[1])
                            return 1;
                        else if (entry1[0]/entry1[1] >entry2[0]/entry2[1])
                            return -1;
                        else
                            return 0;
                    }
                }
        ); //5 10 4 7 3 9 2 5 //5 10 3 9 4 7 2 5
        Arrays.stream(boxTypes).forEach((i) -> {
            Arrays.stream(i).forEach(j -> System.out.print(j + " "));
        });
    }


}
