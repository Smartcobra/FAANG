package GrayCode;

import java.util.ArrayList;

/*
* The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer A representing the total number of bits in the code, print the sequence of gray code.

A gray code sequence must begin with 0.

Problem Constraints
1 <= A <= 16

Input Format

The first argument is an integer A.
Output Format
Return an array of integers representing the gray code sequence.

Example Input

Input 1:

A = 2

Input 1:

A = 1

Example Output

output 1:

[0, 1, 3, 2]

output 2:

[0, 1]

Example Explanation

Explanation 1:

for A = 2 the gray code sequence is:
    00 - 0
    01 - 1
    11 - 3
    10 - 2
So, return [0,1,3,2].

Explanation 1:

for A = 1 the gray code sequence is:
    00 - 0
    01 - 1
So, return [0, 1].

* */
public class Solution {
    public static ArrayList<Integer> grayCode(int a) {
        ArrayList<String> greyCode= grayCodeHelper(a);
        ArrayList<Integer> ans= new ArrayList<>();

        for(String i:greyCode){
            ans.add(Integer.valueOf(i));
            System.out.println(i);
        }
        return ans;
    }

    private static ArrayList<String> grayCodeHelper(int a) {
        if(a==0){
            ArrayList<String> tmp = new ArrayList<>();
            tmp.add("0");
            return tmp;
        }

        if(a==1){
            ArrayList<String> tmp = new ArrayList<>();
            tmp.add("0");
            tmp.add("1");
            return tmp;
        }
        ArrayList<String> result = grayCodeHelper(a-1);
        ArrayList<String> finalResult = new ArrayList<>();


        ////adding "0" at starting
        for(int i=0;i<result.size();i++){
            String s=result.get(i);
            finalResult.add("0"+s);
        }

        ////adding "0" at starting reverse
        for(int i=result.size()-1;i>=0;i--){
            String s=result.get(i);
            finalResult.add("1"+s);
        }
       return finalResult;
    }
    public static void main (String[] args)
    {
        ArrayList<Integer> integers = grayCode(3);
        integers.forEach(System.out::println);
    }

}
