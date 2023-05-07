package Remove_Duplicates_from_Sorted_List_II;

import node.ListNode;
////https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
public class RemoveDuplicatesfromSortedListII_LeetCode {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-100);
        dummy.next = head;
        ListNode curr=dummy;

        while( curr.next !=null && curr.next.next != null){
            if(curr.next.val==curr.next.next.val){
                int duplicate=curr.next.val;
                while (curr.next != null && curr.next.val == duplicate) {
                    curr.next = curr.next.next;
                }
            }else{
                curr=curr.next;
            }
        }
        return dummy.next;
    }
}
