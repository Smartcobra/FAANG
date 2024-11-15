package PasswordGenerator_OpenText;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class PasswordGenDistinct {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String firstInput = sc.nextLine();
        String secondInput = sc.nextLine();
        int number = sc.nextInt();

        String mergedString = (firstInput + secondInput).toLowerCase();

        Set<Character> distinctLetters = new LinkedHashSet<>();

        for (char ch : mergedString.toCharArray()) {
            distinctLetters.add(ch);
        }

        System.out.print("Distinct Letters: ");
        for (char ch : distinctLetters) {
            System.out.print(ch + " ");
        }

        char[] distinctChars = new char[distinctLetters.size()];
        int index = 0;
        for (char ch : distinctLetters) {
            distinctChars[index++] = ch;

        }

        System.out.println("Combinations of length " + number + ":");
        generateCombinations(distinctChars, "", 0, number);

    }

    public static void generateCombinations(char[] distinctChars, String prefix, int start, int length) {
        // Base case: if the desired length is reached, print the combination
        if (length == 0) {
            System.out.println(prefix);
            return;
        }

        // Recursive case: generate combinations
        for (int i = start; i < distinctChars.length; i++) {
            generateCombinations(distinctChars, prefix + distinctChars[i], i + 1, length - 1);
        }
    }
}
