package PhoneDirectory;

import java.util.ArrayList;
/////https://www.scaler.com/academy/mentee-dashboard/class/35028/homework/problems/147/?navref=cl_pb_nv_tb
public class PhoneDirectory {
    public static ArrayList<String> letterCombinations(String A) {

        int idx = 0;
        ArrayList<String> ans = new ArrayList<>();
        StringBuilder output = new StringBuilder();
        String[] mappings = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        helper(A, idx, ans, output, mappings);
        return ans;

    }

    private static  void helper(String digits, int idx, ArrayList<String> ans, StringBuilder output, String[] mappings) {
        if(idx>=digits.length()){
            ans.add(output.toString());
            return;
        }

        int num=digits.charAt(idx)-'0';
        String val=mappings[num];

        for(int i=0;i<val.length();i++){
            output.append(val.charAt(i));
            helper(digits,idx+1,ans,output,mappings);
            output.deleteCharAt(output.length()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("0"));
    }

}
