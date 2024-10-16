package Merge_Two_Sorted_Lists;

import node.ListNode;

public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode l1= list1;
        ListNode l2= list2;
        ListNode head = new ListNode(-100);
        ListNode result = head;

        while(l1 !=null && l2 !=null){
            if(l1.val <l2.val){
                head.next= l1;
                head= l1;
                l1= l1.next;
            }else{
                head.next= l2;
                head= l2;
                l2= l2.next;
            }
        }
        if(l1 ==null){
            head.next=l2;
        }else{
            head.next=l1;
        }

        return result.next;

    }
}
