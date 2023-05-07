package Merge_Two_Sorted_Lists;

import node.Node;

public class Solution2_Iterative {

    public Node mergeTwoLists(Node l1, Node l2) {
        // maintain an unchanging reference to node ahead of the return node.
        Node prehead = new Node(-1);

        Node prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // At least one of l1 and l2 can still have nodes at this point, so connect
        // the non-null list to the end of the merged list.
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }
}
