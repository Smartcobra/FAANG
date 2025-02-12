package Delete_Kth_Node_from_End;

import node.ListNode;

public class Solution {
    public static ListNode removeKthFromEnd(ListNode head, int k) {
        ListNode dummy = new ListNode(0); // Dummy node to handle edge cases
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move fast pointer k+1 steps ahead to maintain a gap
        for (int i = 0; i <= k; i++) {
            if (fast == null) return head; // If k is out of bounds
            fast = fast.next;
        }

        // Move both pointers until fast reaches the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Delete the Kth node
        slow.next = slow.next.next;

        return dummy.next; // Return the new head
    }

    // Helper function to print the linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Creating a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printList(head);

        int k = 2;
        head = removeKthFromEnd(head, k);

        System.out.println("List after removing " + k + "th node from end:");
        printList(head);
    }
}
