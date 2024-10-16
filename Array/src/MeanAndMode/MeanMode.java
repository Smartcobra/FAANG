package MeanAndMode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MeanMode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] numbers = new int[n];
        int sum = 0;

        // Taking input for the elements of the array
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
            sum += numbers[i];  // Summing up the elements for the mean calculation
        }

        // Calculate mean
        double mean = (double) sum / n;

        // Calculate mode
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int number : numbers) {
            frequencyMap.put(number, frequencyMap.getOrDefault(number, 0) + 1);
        }

        int mode = numbers[0];
        int maxCount = 0;

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mode = entry.getKey();
            }
        }

        // Display the mean and mode
        System.out.println("Mean: " + mean);
        System.out.println("Mode: " + mode);
    }
}
