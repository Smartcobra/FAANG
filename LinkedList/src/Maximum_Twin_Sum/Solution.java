package Maximum_Twin_Sum;

import node.ListNode;

////https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/
public class Solution {
    public int pairSum(ListNode head) {
        int max= Integer.MIN_VALUE;
        ListNode slow= head;
        ListNode fast=head;

        while(fast.next !=null && fast.next.next !=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode tmp =reverse(slow.next);
        slow.next=tmp;

        ListNode p1=head;
        ListNode p2=tmp;

        while(p2!=null){
            max=Math.max(max,p1.val+p2.val);
            p1=p1.next;
            p2=p2.next;
        }
        return max;

    }

    public ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode Next=null;
        ListNode curr =head;

        while(curr!=null){
            Next= curr.next;
            curr.next= prev;
            prev= curr;
            curr=Next;
        }

        return prev;
    }
}
