package Integer_To_Roman;

//////https://leetcode.com/problems/integer-to-roman/submissions/
class Solution {
    public String intToRoman(int num) {
        int[] sNum = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] sRoman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder roman= new StringBuilder();

        for(int i=0;i<sNum.length;i++){
            while(num>=sNum[i]){
                roman.append(sRoman[i]);
                num =num-sNum[i];
            }
        }

        return roman.toString();

    }
}
