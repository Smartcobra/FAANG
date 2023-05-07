package Swap_Nodes_In_Pairs;

import node.ListNode;

public class SwapNodesInPairs {

    public static ListNode swapPairs(ListNode head) {
        if (head == null) return null;

        ListNode dummy = new ListNode(-100);
        dummy.next=head;
        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null && curr.next != null) {
            ListNode first = curr;
            ListNode second = curr.next;

            prev.next = second;
            first.next = second.next;
            second.next = first;

            prev = first;
            curr = first.next;


        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head= new ListNode(1);
//        head.next=new ListNode(2);
//        head.next.next=new ListNode(3);
//        head.next.next.next=new ListNode(4);
//        head.next.next.next.next=new ListNode(5);
//        head.next.next.next.next.next=new ListNode(6);
//        head.next.next.next.next.next.next=new ListNode(7);
//        head.next.next.next.next.next.next.next=new ListNode(8);

        System.out.println(swapPairs(head));
    }
}
