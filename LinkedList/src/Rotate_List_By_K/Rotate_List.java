package Rotate_List_By_K;

import node.ListNode;

public class Rotate_List {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;

        ListNode oldTail = head;
        int length = 1;
        ////finding length we can find length by the blow method also

            /*
            *
            *     int length=0;
                  ListNode currentNode= head;
                  while(currentNode!=null){
                  length++;
                  currentNode=currentNode.next;
                  }
            *   if find this way we lost the tail.next , which should connect to head
            * */
        while (oldTail.next != null) {
            length++;
            oldTail = oldTail.next;
        }

        k = k % length;   // if k larger than the list given length

        ///connect oldTail to head
        oldTail.next = head;

        //find new tail
        int nodeBeforeNewTail = length - k - 1;
        ListNode newTail = head;
        for (int i = 0; i < nodeBeforeNewTail; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;

    }

}
