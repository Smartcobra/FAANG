package Add_Two_Numbers_II;

import node.ListNode;

//https://leetcode.com/problems/add-two-numbers-ii/solution/
public class AddTwoNumbersII {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);


        ListNode result = new ListNode(0);
        ListNode curr = result;
        int carry = 0;

        while( l1 !=null || l2 !=null || carry !=0){
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            int sum = x+y+carry;
            carry = sum/10;
            curr.next = new ListNode(sum%10);
            curr = curr.next;


            if( l1!=null){
                l1 = l1.next;
            }

            if( l2!=null){
                l2 = l2.next;
            }
        }

        return reverse(result.next);
    }


    public ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null){
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;

        }
        return prev;
    }
}
