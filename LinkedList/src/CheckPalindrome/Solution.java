package CheckPalindrome;

import node.ListNode;
//https://leetcode.com/problems/palindrome-linked-list/
public class Solution {

    public boolean isPalindrome(ListNode head) {
            ListNode slow=head;
            ListNode fast=head;

            while(fast.next !=null && fast.next.next !=null){
                slow=slow.next;
                fast=fast.next.next;
            }

            ListNode tmp= reverse(slow.next);
            slow.next = tmp;
            ListNode p1=head;
            ListNode p2=slow.next;

            while(p2 !=null){
                if (p1.val!=p2.val) return false;

                p1 = p1.next;
                p2=p2.next;
            }

            return true;


        }

        public ListNode reverse(ListNode head){
            ListNode prev=null;
            ListNode Next=null;
            ListNode curr = head;

            while(curr !=null){
                Next= curr.next;
                curr.next=prev;
                prev=curr;
                curr=Next;
            }
            return prev;
        }
}
