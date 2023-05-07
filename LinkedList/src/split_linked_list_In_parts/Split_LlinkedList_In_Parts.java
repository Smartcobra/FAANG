package split_linked_list_In_parts;

import node.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

////  https://leetcode.com/problems/split-linked-list-in-parts/
public class Split_LlinkedList_In_Parts {


    public static ListNode[] splitListToParts(ListNode head, int k) {

        ListNode curr=head;
        int length=getLength(head);
        int splitSize = length/k;
        int extraNode = length%k;
        ListNode prev =null;
        List<ListNode> ans = new ArrayList<>();

        while( head !=null ){
            int eachPartSize = splitSize;
            ans.add(curr);
            while(eachPartSize >0){
                prev = curr;
                curr = curr.next;
                eachPartSize--;
            }

            if(extraNode !=0  && curr !=null){
                extraNode--;
                prev = curr;
                curr = curr.next;
            }

            if(prev !=null){
                head =curr;
                prev.next =null;
            }

        }

        while (ans.size() !=k){
            ans.add(null);
        }


        return ans.toArray(new ListNode[0]);
    }

    private static int getLength(ListNode head) {
        int count=0;
        while (head !=null){
            count++;
            head=head.next;
        }

        return count;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next.next = new ListNode(10);

        System.out.println(Arrays.toString(splitListToParts(head, 4)));


    }

}
