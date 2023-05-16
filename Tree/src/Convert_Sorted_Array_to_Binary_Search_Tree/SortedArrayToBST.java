package Convert_Sorted_Array_to_Binary_Search_Tree;

import create.Node;

//https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
public class SortedArrayToBST {
    int[] nums;

    public Node<Integer> sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return sortedArrayToBSTHelper(0, nums.length - 1);
    }

    private Node<Integer> sortedArrayToBSTHelper(int left, int right) {
        if (left > right) return null;

        int mid = (left + right) / 2;

        Node<Integer> root = new Node<>(nums[mid]);
        root.left = sortedArrayToBSTHelper(left, mid - 1);
        root.right = sortedArrayToBSTHelper(mid + 1, right);

        return root;
    }


    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
    }
}
