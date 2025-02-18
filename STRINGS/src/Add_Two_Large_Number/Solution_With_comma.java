package Add_Two_Large_Number;

import java.text.NumberFormat;
import java.util.Locale;

public class Solution_With_comma {
    public static String addLargeNumbers(String num1, String num2) {
        // Remove commas from the input numbers
        num1 = num1.replaceAll(",", "");
        num2 = num2.replaceAll(",", "");

        // Perform large number addition
        String sum = addStrings(num1, num2);

        // Format the sum with commas
        return formatWithCommas(sum);
    }

    private static String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = (i >= 0) ? num1.charAt(i) - '0' : 0;
            int digit2 = (j >= 0) ? num2.charAt(j) - '0' : 0;

            int sum = digit1 + digit2 + carry;
            carry = sum / 10;
            result.append(sum % 10);

            i--;
            j--;
        }

        return result.reverse().toString();
    }



    private static String formatWithCommas(String number) {
        StringBuilder formatted = new StringBuilder();
        int len = number.length();

        // First part (before lakh), insert commas after every 2 digits
        int count = 0;
        for (int i = len - 1; i >= 0; i--) {
            formatted.append(number.charAt(i));
            count++;

            if ((count == 3 && i > 0) || (count > 3 && (count - 3) % 2 == 0 && i > 0)) {
                formatted.append(',');
            }
        }

        return formatted.reverse().toString();
    }
    public static void main(String[] args) {
        String num1 = "1,99,000";
        String num2 = "5,15,000";
        System.out.println(addLargeNumbers(num1, num2));  // Output: 6,20,000
    }
}
