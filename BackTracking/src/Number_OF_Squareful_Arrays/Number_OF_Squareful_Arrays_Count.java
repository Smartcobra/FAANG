package Number_OF_Squareful_Arrays;

import java.util.*;

public class Number_OF_Squareful_Arrays_Count {
    static int count = 0;

    public static int permute(ArrayList<Integer> input) {
        ArrayList<Integer> cur = new ArrayList<>();
        Collections.sort(input);
        boolean[] choices = new boolean[input.size()];
        if (input.size() == 1 && !isSquare(input.get(0), input.get(0))) {
            return 0;
        }
        getAllUniquPermutaion(input, cur, choices);
        return count;
    }

    private static void getAllUniquPermutaion(ArrayList<Integer> input, ArrayList<Integer> cur, boolean[] choices) {

        if (input.size() == cur.size()) {
            count++;
            return;
        }

        for (int i = 0; i < input.size(); i++) {
            if (choices[i]) {
                continue;
            }
            if (i != 0 && Objects.equals(input.get(i - 1), input.get(i)) && !choices[i - 1]) {
                continue;
            }
            if (cur.size() > 0 && !isSquare(cur.get(cur.size() - 1), input.get(i))) {
                continue;
            }
            choices[i] = true;
            cur.add(input.get(i));
            getAllUniquPermutaion(input, cur, choices);
            choices[i] = false;
            cur.remove(input.get(i));
        }
    }

    private static boolean isSquare(int a, int b) {
        int sqrt = (int) Math.sqrt(a + b);
        return a + b == sqrt * sqrt;
    }

    public static void main(String[] args) {
//        ArrayList<Integer> input = new ArrayList<>();
//        input.add(1);
//        input.add(17);
//        input.add(8);
//        System.out.println(permute(input));

//        ArrayList<Integer> input = new ArrayList<>();
//        input.add(36229);
//        input.add(1020);
//        input.add(69);
//        input.add(127);
//        input.add(162);
//        input.add(127);
//        System.out.println(permute(input));

        ArrayList<Integer> input2 = new ArrayList<>();
        input2.add(16777);
        input2.add(1179);
        input2.add(265);
        input2.add(135);
        input2.add(90);
        input2.add(135);
        input2.add(34);
        System.out.println(permute(input2));
//
//        ArrayList<Integer> input = new ArrayList<>();
//        input.add(41);
//        System.out.println(permute(input));
        // System.out.println(isSquare(41,41));
    }
}
