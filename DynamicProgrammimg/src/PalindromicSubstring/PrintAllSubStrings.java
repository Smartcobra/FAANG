package PalindromicSubstring;

public class PrintAllSubStrings {
    public static void printSubString(String str){
        int len=str.length();

        for(int i=0;i<len;i++){
            for(int j=i+1;j<=len;j++){
                System.out.println(str.substring(i,j));
            }
        }
    }

    public static void main(String[] args) {
        String str="abccbc";
        printSubString(str);
    }
}
