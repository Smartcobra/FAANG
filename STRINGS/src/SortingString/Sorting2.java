package SortingString;

public class Sorting2 {
    public static void sortString(String str){
        int maxString=26;
        int [] frequency= new int [26];

        for(char x:str.toCharArray()){
            frequency[x-'a']++;
        }
        for(int i=maxString-1;i>=0;i--){
            for (int j = 0; j < frequency[i]; j++) {
                System.out.print((char) (i + 'a'));
            }
        }

    }

    public static void main(String[] args) {
        sortString("geeksforgeeks");
    }
}
