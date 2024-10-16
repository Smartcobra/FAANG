package Linked_List_Cycle_II;

import node.ListNode;

public class Solution {

    ///https://leetcode.com/problems/linked-list-cycle-ii/submissions/
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return null;
        ListNode slow = head;
        ListNode fast= head;

        while(fast !=null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow==fast){
                ListNode tmp= head;
                while(tmp!=slow){
                    tmp=tmp.next;
                    slow=slow.next;
                }
                return slow;
            }
        }

        return null;

    }
}
