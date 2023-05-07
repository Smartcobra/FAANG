package Merge_Two_Sorted_Lists;

import node.Node;

///Time complexity : O(n+m)
//Space complexity : O(n+m)  due to use of stack

public class Solution_Recursion {

    public Node mergeTwoLists(Node l1, Node l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.data < l2.data) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }
}
