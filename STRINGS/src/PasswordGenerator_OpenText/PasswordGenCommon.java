package PasswordGenerator_OpenText;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class PasswordGenCommon {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String firstInput = sc.nextLine();
        String secondInput = sc.nextLine();
        int number = sc.nextInt();

        Set<Character> firstSet = new HashSet<>();
        Set<Character> secondSet = new HashSet<>();

        for (char ch : firstInput.toLowerCase().toCharArray()) {
            firstSet.add(ch);
        }

        for (char ch : secondInput.toLowerCase().toCharArray()) {
            secondSet.add(ch);
        }

        Set<Character> commonChars = new LinkedHashSet<>(firstSet);
        commonChars.retainAll(secondSet);


        char[] commonCharsArray = new char[commonChars.size()];
        int index = 0;
        for (char ch : commonChars) {
            commonCharsArray[index++] = ch;
        }

        System.out.println("Combinations of length " + number + ":");
        generateCombinations(commonCharsArray, "", 0, number);

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
