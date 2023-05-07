package reverse_String;

import java.util.Scanner;

public class Solution {
    public static void printReverse(String str) {
        if (str.length() <= 1 || str == null) {
            System.out.println(str);
        }else{
            System.out.print(str.charAt(str.length() - 1));
            printReverse(str.substring(0, str.length() - 1));
        }


    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String str= sc.nextLine();
        printReverse(str);

//        String str = "Geeks for Geeks";
//        Solution obj = new Solution();
//        obj.printReverse(str);
    }
}
