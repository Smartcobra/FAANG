import java.util.HashSet;
import java.util.Set;

public class Test {
    public String solution(String forth) {
        // Initialize counters for each direction
        int north = 0, east = 0, west = 0;

        // Count the directions in the 'forth' path
        for (char ch : forth.toCharArray()) {
            if (ch == 'N') {
                north++;
            } else if (ch == 'E') {
                east++;
            } else if (ch == 'W') {
                west++;
            }
        }

        // Construct the return path by balancing movements
        int south = north;  // Balance all 'N' with 'S'
        int westToEast = Math.min(west, east);  // Balance 'W' with 'E'
        int remainingWest = west - westToEast;
        int remainingEast = east - westToEast;

        // Build the return path
        StringBuilder returnPath = new StringBuilder();
        for (int i = 0; i < remainingWest; i++) {
            returnPath.append('W');
        }
        for (int i = 0; i < south; i++) {
            returnPath.append('S');
        }
        for (int i = 0; i < remainingEast; i++) {
            returnPath.append('E');
        }

        return returnPath.toString();

    }
}
