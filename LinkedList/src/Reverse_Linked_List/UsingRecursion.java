package Reverse_Linked_List;

import node.ListNode;

public class UsingRecursion {

    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        if(head.next==null) return head;

        ListNode newHead= reverseList(head.next);
        head.next.next= head;
        head.next=null;
        return newHead;

    }
}
