package Linked_List_Cycle_II;

import node.ListNode;
//https://leetcode.com/problems/linked-list-cycle-ii/

//https://www.scaler.com/academy/mentee-dashboard/class/29551/assignment/problems/43?navref=cl_tt_lst_sl
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean isCycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                isCycle = true;
                break;
            }
        }

        if (isCycle) {
            ListNode p1 = head;
            ListNode p2 = fast;

            while (p1 != p2) {
                p1 = p1.next;
                p2 = p2.next;
            }

            return p1;
        } else {
            return null;
        }

    }
}

