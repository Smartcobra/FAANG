package BinarySearch;

public class BinarySearch {
    int binarySearch(int[] array, int element, int low, int high) {
        while (low <= high) {

            // get index of mid element
            int mid = low + (high - low) / 2;

            // if element to be searched is the mid element
            if (array[mid] == element)
                return mid;

            // if element is less than mid element
            // search only the left side of mid
            if (array[mid] < element)
                low = mid + 1;

                // if element is greater than mid element
                // search only the right side of mid
            else
                high = mid - 1;
        }

        return -1;
    }
}
