import java.util.*;

public class First_Negative_Integer_Every_Window_Size_K {
    public static  List<Integer>  getFirstNegative(List<Integer> input, int k) {
        int n = input.size();
        int left = 0;
        int right = 0;
        List<Integer> result = new ArrayList<>();

        Queue<Integer> negatives = new LinkedList<>();

        while (right < n) {
            if (input.get(right) < 0) {
                negatives.add(input.get(right));
            }

            if (right - left + 1 == k) {
                if(!negatives.isEmpty()){
                    result.add(negatives.peek());
                }else{
                    result.add(0);
                }

                if (!negatives.isEmpty()) {
                    if (Objects.equals(input.get(left), negatives.peek())) {
                        negatives.remove();
                    }
                }
                left++;
            }
            right++;
        }
        return result;

    }
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(12, -1, -7, 8, 15, 30, 16, 28);
        int k = 3;
        System.out.println(getFirstNegative(input, k));  // Output: [-1, -1, -7, 0, 0, 0]
    }
}
