package read_billion_reacords;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.*;
public class Parallel_Streams {
    static class Stats {
        double min;
        double max;
        double sum;
        long count;

        void accept(double price) {
            if (price < min) min = price;
            if (price > max) max = price;
            sum += price;
            count++;
        }

        static Stats combine(Stats a, Stats b) {
            Stats result = new Stats();
            result.min = Math.min(a.min, b.min);
            result.max = Math.max(a.max, b.max);
            result.sum = a.sum + b.sum;
            result.count = a.count + b.count;
            return result;
        }
    }

    public static void main(String[] args) throws IOException {
        String filename = "data/real_estate_prices.txt";

        long startTime = System.currentTimeMillis();

        // Read all lines (caution: memory usage for 1B lines might be enormous)
        List<String> lines = Files.readAllLines(Paths.get(filename));

        // Use a concurrent map: propertyID -> Stats
        Map<String, Stats> statsMap = lines
                .parallelStream()
                .map(line -> line.split(";"))
                .filter(parts -> parts.length >= 2)
                .map(parts -> new AbstractMap.SimpleEntry<>(parts[0], parsePrice(parts[1])))
                .filter(entry -> !Double.isNaN(entry.getValue())) // skip invalid
                .collect(Collectors.toConcurrentMap(
                        AbstractMap.SimpleEntry::getKey,
                        e -> {
                            Stats st = new Stats();
                            st.min = e.getValue();
                            st.max = e.getValue();
                            st.sum = e.getValue();
                            st.count = 1;
                            return st;
                        },
                        (st1, st2) -> Stats.combine(st1, st2)
                ));

        long endTime = System.currentTimeMillis();

        // Print results
        System.out.print("{");
        statsMap.forEach((prop, st) -> {
            double avg = st.sum / st.count;
            System.out.printf("%s=%.1f/%.1f/%.1f, ", prop, st.min, avg, st.max);
        });
        System.out.println("\b\b}");
        System.out.println("Parallel stream duration: " + ((endTime - startTime) / 1000.0) + " seconds");
    }

    private static double parsePrice(String s) {
        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return Double.NaN;
        }
    }
}
/*
3–4 minutes
 */