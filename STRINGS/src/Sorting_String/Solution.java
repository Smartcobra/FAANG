package Sorting_String;

public class Solution {
    public static void sortString(String str){
        int maxString=26;
        int [] frequency= new int [26];

        for(char x:str.toCharArray()){
            frequency[x-'a']++;
        }
         for(int i=0;i<maxString;i++){
             for (int j = 0; j < frequency[i]; j++) {
                 System.out.print((char) (i + 'a'));
             }
         }

    }

    public static void main(String[] args) {
        sortString("geeksforgeeks");
    }
}
