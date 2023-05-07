package CheckPalindrome;

import node.Node;

import java.util.ArrayList;

/*
*
*
    Find the end of the first half.
    Reverse the second half.
    Determine whether or not there is a palindrome.
    Restore the list.
    Return the result.
*/
public class Solution_2 {
    public static boolean isPalindrome(Node head) {

        if(head==null) return true;


        Node first_half_end= findMid(head);
        Node second_half_start=reverseLinkedList(first_half_end);

        boolean result= true;

        Node p1=head;
        Node p2=second_half_start;

        while( result && p2 !=null){
            if(p1.data !=p2.data) result= false;
            p1=p1.next;
            p2=p2.next;
        }
        first_half_end.next = reverseLinkedList(second_half_start);
        return result;

    }

    private static Node findMid(Node head){
        Node fast= head;
        Node slow= head;

        while(fast.next !=null && fast.next.next !=null){
            fast=fast.next.next;
            slow=slow.next;

        }
        return slow;
    }

    private static Node reverseLinkedList( Node head){

        Node prev_node=null;
        Node cur_node=head;

        while(cur_node!= null){
            Node next_node= cur_node.next;

            cur_node.next=prev_node;
            prev_node=cur_node;
            cur_node=next_node;

        }
        return prev_node;

    }

}
