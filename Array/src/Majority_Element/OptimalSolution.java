package Majority_Element;

/**
 * Boyer-Moore Voting Algorithm
 *
 * I implemented the Boyer-Moore Voting Algorithm, starting with the assumption that the first element is the majority element
 * and a counter cnt set to 1. As I iterated through the array, I increased the counter when encountering the same element,
 * and decreased it when encountering a different one. If the counter reached zero, it meant the current candidate was no
 * longer in the majority up to this point, and I needed to choose the next element as the new candidate. This approach ensures
 * that the candidate at the end of the array is the majority element, given the problem's constraints.
 */
public class OptimalSolution {
    public int majorityElement(int[] nums) {
        int ele=0;
        int count=0;
        int count1=0;

        for (int num : nums) {
            if (count == 0) {   // starting new section
                ele = num;
                count = 1;
            } else if (ele == num) {
                count++;
            } else {
                count--;
            }
        }

        for (int num : nums) {
            if (num == ele) count1++;
        }

        if(count1 > nums.length/2) return ele;

        return -1;
    }
}
