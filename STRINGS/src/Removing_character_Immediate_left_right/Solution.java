package Removing_character_Immediate_left_right;

import java.util.Scanner;

//Write a Java program to read a string and returns after removing a specified character and its immediate left and right characters.Sample Solution:
public class Solution {

    public static String excludeHash(String stng) {
        int len = stng.length();
        String resultString = "";
        for (int i = 0; i < len; i++) {
            if (i == 0 && stng.charAt(i) != '#')  ///# is the char where we remove left and right
                resultString += stng.charAt(i);
            if (i > 0 && stng.charAt(i) != '#' && stng.charAt(i - 1) != '#')
                resultString += stng.charAt(i);
            if (i > 0 && stng.charAt(i) == '#' && stng.charAt(i - 1) != '#')
                resultString = resultString.substring(0, resultString.length() - 1);
        }
        return resultString;
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String str1= sc.nextLine();
       // String str1 = "test#string";
        System.out.println("The given strings is: " + str1);
        System.out.println("The new string is: " + excludeHash(str1));
    }
}




