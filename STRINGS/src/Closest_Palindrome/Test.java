package Closest_Palindrome;

public class Test {
    static boolean checkPalindrome(String str) {
        int n = str.length();
        int count = 0;
        for (int i = 0; i < n / 2; ++i)
            if (str.charAt(i) != str.charAt(n - i - 1))
                ++count;
        return (count <= 1);
    }

    public static void main(String[] args) {

        String str = "abba";

        if (checkPalindrome(str))

            System.out.println("Yes");
        else
            System.out.println("No");

    }
}
