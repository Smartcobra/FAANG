package DesignLinkedList;


import com.sun.org.apache.bcel.internal.generic.ARETURN;

class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}


public class DesignLinkedList {
    public static ListNode head = null;
    public static int size = 0;

    public static void insert(int val, int idx) {
        ListNode newNode = new ListNode(val);

        if (idx == 0) {
            newNode.next = head;
            head = newNode;
            size++;
            return;
        }
        if (idx > size) {
            return;
        }
        size++;
        /////Inserting at any position except 0;
        ///stop before one position of target index;
        /// if idx=3 , we will stop at 3rd element that is i=2;
        ListNode cur = head;
        for (int i = 1; i < idx; i++) {
            cur = cur.next;
        }

        newNode.next = cur.next;
        cur.next = newNode;
    }

    public static void delete(int idx) {
        if (head == null || idx >= size) {
            return;
        }
        //if idx=0;  means starting element
        if (idx == 0) {
            head = head.next;
            size--;
            return;
        }
        size--;
        ///stop before one position of target index;
        /// if idx=3 , we will stop at 3rd element that is i=2;
        ListNode cur = head;
        for (int i = 1; i < idx; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;

    }

    public ListNode solve(int[][] A) {
        head = null;
        size = 0;
        int n = A.length;

        for (int i = 0; i < n; i++) {
            if (A[i][0] == 0) {
                insert(A[i][1], 0);
            } else if (A[i][0] == 1) {
                insert(A[i][1], size);
            } else if (A[i][0] == 3) {
                delete(A[i][1]);
            } else {
                insert(A[i][1], A[i][2]);
            }
        }
        return head;
    }

}
