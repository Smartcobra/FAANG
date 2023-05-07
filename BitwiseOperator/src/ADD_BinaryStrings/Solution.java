package ADD_BinaryStrings;

public class Solution {
    public static String addBinary(String A, String B) {
        int i=0;
        int alen=A.length();
        int blen=B.length();
        int carry=0;
        String result="";

        while(i<alen || i<blen || carry!=0){
            int x=0;
            if(i<alen && A.charAt(alen-1-i)=='1') x=1;
            int y=0;
            if(i<blen && B.charAt(blen-1-i)=='1') y=1;

            result= ((x+y+carry)%2) +result;
            carry=(x+y+carry)/2;


            i++;

        }

        return result;
    }

    public static void main(String[] args) {
//        String A ="1010110111001101101000";
//        String B = "1000011011000000111100110";

        String A ="100";
        String B = "11";

        System.out.println(addBinary(A,B));
    }
}
