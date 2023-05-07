package Linked_List_Cycle;

import node.ListNode;

//https://leetcode.com/problems/linked-list-cycle/
public class Solution2 {
    public boolean hasCycle(ListNode head) {

        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow==fast){
                return true;
            }
        }

        return false;

    }
}
