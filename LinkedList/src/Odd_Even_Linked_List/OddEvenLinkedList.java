package Odd_Even_Linked_List;

import node.ListNode;

///https://leetcode.com/problems/odd-even-linked-list/
public class OddEvenLinkedList {


    public ListNode oddEvenList(ListNode head) {

        if (head ==  null) return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;


        while(even !=null && even.next !=null){
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }
}
