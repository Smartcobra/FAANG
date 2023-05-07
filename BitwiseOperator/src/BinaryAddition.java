public class BinaryAddition {
//    public static String  addBinary(String a, String b) {
//        int carry=0;
//        String result="";
//        int i=0;
//        int alen=a.length();
//        int blen=b.length();
//        while(i<alen||i<blen||carry!=0){
//            int x = 0;
//            if(i<alen && a.charAt(alen-1-i) =='1') x  = 1;
//            int y = 0;
//            if(i<blen && b.charAt(blen-1-i) =='1') y = 1;
//
//            result=(x+y+carry)%2+result;
//            carry=(x+y+carry)/2;
//            i++;
//        }
//        return result;
//    }

    public static String  addBinary(String A, String B) {
        int a_len = A.length();
        int b_len = B.length();

        int carry = 0;
        String result = "";
        int i = 0;
        while (i < a_len || i < b_len || carry != 0) {
            int x = 0;
            if (i < a_len && A.charAt(a_len - 1) == '1') {
                x = 1;
            }
            int y = 0;
            if (i < b_len && B.charAt(b_len - 1) == '1') {
                y = 1;
            }

            result = (carry + x + y) % 2 + result;
            carry = (x + y + carry) / 2;


            i++;
        }
        return result;
    }



    public static void main(String[] args) {
       String A = "1010110111001101101000";
        String B = "1000011011000000111100110";
        System.out.println(addBinary(A,B));

        //1001110001111010101001110
        //1001110001111010101001110


    }
}
