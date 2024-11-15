package Find_Nth_Node_From_End;

import node.ListNode;

public class Solution {

    public ListNode findNthLast(ListNode head, int n) {

        ListNode fast = head;
        ListNode slow = head;

        for (int i = 1; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
