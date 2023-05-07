package LargestNumber;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public String largestNumber(final int[] A) {
        int count = 0;
        String[] strArr = Arrays.stream(A).mapToObj(String::valueOf).toArray(String[]::new);
//        Arrays.sort(strArr, new Comparator<String>() {
//            @Override
//            public int compare(String str1, String str2) {
//                String c1 = str1.concat(str2);
//                String c2 = str2.concat(str1);
//                return c2.compareTo(c1);
//            }
//        });


        Comparator<String> compare = (str1, str2) -> {
            String c1 = str1.concat(str2);
            String c2 = str2.concat(str1);
            return c2.compareTo(c1);
        };

        Arrays.sort(strArr,compare);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            sb.append(strArr[i]);

            if (Integer.parseInt(strArr[i]) == 0) {
                count++;
            }

        }
        if (count == strArr.length) return "0";
        return sb.toString();
    }
}
