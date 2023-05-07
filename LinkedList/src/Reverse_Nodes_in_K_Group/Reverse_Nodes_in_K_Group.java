package Reverse_Nodes_in_K_Group;

import node.ListNode;

//https://leetcode.com/problems/reverse-nodes-in-k-group/discuss/183356/Java-O(n)-solution-with-super-detailed-explanation-and-illustration
public class Reverse_Nodes_in_K_Group {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head==null) return null;

        ListNode dummy = new ListNode(-100);
        dummy.next=head;
        ListNode pointer = dummy;

        while(true){
            ListNode tmp = pointer;
            /// check the if k node exists
            for(int i=0;i<k && tmp!=null;i++){
                tmp = tmp.next;
            }

            if(tmp==null) break;
            //reverse group
            ListNode curr = pointer.next;
            ListNode prev = null;
            for(int i=0;i<k;i++){
                ListNode nextNode = curr.next;
                curr.next =prev;
                prev =curr;
                curr =nextNode;
            }
           /// connect the pointer
            ListNode tail = pointer.next;
            tail.next = curr;
            pointer.next = prev;
            pointer = tail;
        }
        return dummy.next;
    }

}
