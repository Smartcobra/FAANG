package otherStringAlgo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
    // * Use either of these methods for input
    public static void main(String[] args) throws IOException {


        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String str = input.substring(0, 1);
        int k = Integer.parseInt(input.substring(2));           // Reading input from STDIN

        String inputStr = br.readLine();


        System.out.println(str);
        System.out.println(k);
        System.out.println(inputStr);
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            Long num = Long.parseLong(str.substring(i));

            if (num % k == 0) {
                index = i;
                System.out.println(str.substring(0, index));

            }
        }

    }
}
