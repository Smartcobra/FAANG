package Reverse_Linked_List_II;

import node.ListNode;


//https://leetcode.com/problems/reverse-linked-list-ii/
public class ReverseLinkedList_II {

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-100);
        dummy.next = head;
        ListNode leftPrev = dummy;
        ListNode curr = head;
        /*
         * step-1
         *  create a dummy node
         *  reach till the left
         *  hold the leftPrevious node
         * */
        for (int i = 0; i < left - 1; i++) {
            leftPrev = curr;
            curr = curr.next;
        }
        /*
         * step-2
         * simply use reverse linked list process to reverse from left to right
         * */
        ListNode prev = null;
        for (int i = 0; i < right - left + 1; i++) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }

        /*
        *  step -3
        *
        * */
        leftPrev.next.next = curr;
        leftPrev.next = prev;

        return dummy.next;

    }

    public static void main(String[] args) {
        ListNode head= new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(10);
        head.next.next.next=new ListNode(20);
        head.next.next.next.next=new ListNode(30);
        head.next.next.next.next.next=new ListNode(40);
        head.next.next.next.next.next.next=new ListNode(5);
        head.next.next.next.next.next.next.next=new ListNode(7);

        System.out.println(reverseBetween(head,3,6));

    }


}
