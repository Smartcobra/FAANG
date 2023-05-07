package Convert_Binary_Number_Linked_List_To_Integer;

import node.ListNode;

//https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
public class Convert_Binary_Number_Linked_List_To_Integer {

    public int getDecimalValue(ListNode head) {

        int num = head.val;

        while (head.next != null) {
            num = num * 2 + head.next.val;
            head = head.next;
        }

        return num;


    }
}
