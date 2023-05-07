package reverse_Number;

public class ReverseNumber {

    public static int reverseNumber(int num) {

        int reversedNumber = 0;
        if (num == 0) return reversedNumber;

        while (num != 0) {
            int rem = num % 10;
            reversedNumber = reversedNumber * 10 + rem;
            num = num / 10;
        }
        return reversedNumber;
    }

    public static void main(String[] args) {
        System.out.println(reverseNumber(14321));
      //  System.out.println(Integer.MAX_VALUE); //2147483647
     //   System.out.println(Integer.MIN_VALUE); //-2147483648



    }
}
