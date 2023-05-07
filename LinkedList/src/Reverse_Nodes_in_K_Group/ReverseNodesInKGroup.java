package Reverse_Nodes_in_K_Group;

import node.ListNode;

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {

        if (head==null) return null;

        ListNode curr=head;
        ListNode prev=null;
        int count = 0;

        while(curr != null && count < k){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
            count++;
        }

        head.next = reverseKGroup(curr, k);

        return prev;
    }
}
