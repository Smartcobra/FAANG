package Merge_Two_Sorted_Lists;

import node.ListNode;

//https://leetcode.com/problems/merge-two-sorted-lists/
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode head = new ListNode(-1);
        ListNode tmp = head;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tmp.next = list1;
                list1 = list1.next;

            } else {
                tmp.next = list2;
                list2 = list2.next;
            }

            tmp = tmp.next;
        }


        /// if the length of list1 and list2 is not same; we have to merge them at the last
        if (list1 != null) {
            tmp.next = list1;
        } else if (list2 != null) {
            tmp.next = list2;
        }


        return head.next;

    }

    public static void main(String[] args) {
        ListNode node1= new ListNode(1);
        node1.next=new ListNode(2);
        node1.next.next=new ListNode(4);

        ListNode node2= new ListNode(1);
        node2.next=new ListNode(3);
        node2.next.next=new ListNode(4);

        MergeTwoLists ml= new MergeTwoLists();
        System.out.println(ml.mergeTwoLists(node1,node2));

    }
}
