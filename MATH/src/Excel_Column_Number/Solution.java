package Excel_Column_Number;

public class Solution {
    public static int titleToNumber(String A) {
        int result=0;
        for(char c:A.toCharArray()){
            int d= c-'A'+1;
            result =result*26+d;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("BCD"));

    }
}
