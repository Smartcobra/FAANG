package Insertion_Sort_List;

import node.ListNode;

///https://leetcode.com/problems/insertion-sort-list/
public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {

        ListNode start = new ListNode(-100);
        start.next = head;
        ListNode prev = start;
        ListNode curr = head;

        while (curr != null) {
            if (curr.next != null && (curr.next.val < curr.val)) {

                while (prev.next != null && prev.next.val < curr.next.val) {
                    prev = prev.next;
                }
                ListNode tmp = prev.next;
                prev.next = curr.next;
                curr.next = curr.next.next;
                prev.next.next = tmp;
                prev = start;


            } else {
                curr = curr.next;
            }
        }
        return start.next;

    }
}
