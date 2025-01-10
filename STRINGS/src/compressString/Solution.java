package compressString;

public class Solution {
    public static String compressString(String input) {
        StringBuilder compressed = new StringBuilder();
        int count = 1; // Start count at 1 since we compare consecutive characters

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                count++;
            } else {
                appendCompressed(compressed, input.charAt(i - 1), count);
                count = 1; // Reset count for new character
            }
        }

        // Append the last character group
        appendCompressed(compressed, input.charAt(input.length() - 1), count);

        return compressed.toString();
    }

    private static void appendCompressed(StringBuilder compressed, char character, int count) {
        while (count > 9) {
            compressed.append(9).append(character);
            count -= 9;
        }
        compressed.append(count).append(character);
    }

    public static void main(String[] args) {
        String input = "AABCCC"; // Example input
        String output = compressString(input);
        System.out.println("Compressed string: " + output);

        // Test with a large count
        String largeInput = "AAAAAAAAAAAAA"; // 13 'A's
        String largeOutput = compressString(largeInput);
        System.out.println("Compressed string for large input: " + largeOutput);
    }
}
