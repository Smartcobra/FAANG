package Remove_Duplicates_from_Sorted_List_II;

import node.ListNode;


public class RemoveDuplicatesfromSortedListII {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                int duplicate = curr.val;

                while (curr.next != null && curr.next.val == duplicate) {
                    curr.next = curr.next.next;
                }
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
      // input :: [1,2,3,3,4,4,5]   output ::: [1,2,3,4,5]
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(3);
        head.next.next.next.next=new ListNode(4);
        head.next.next.next.next.next=new ListNode(4);
        head.next.next.next.next.next.next=new ListNode(5);
        System.out.println(deleteDuplicates(head));
    }
}
