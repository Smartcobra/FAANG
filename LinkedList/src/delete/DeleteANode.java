package delete;

import node.Node;

public class DeleteANode {
    //delete function

    public static Node deleteAtStart(Node head) {
        if (head == null) {
            System.out.println("Head is empty");
            return null;
        }
        head = head.next;

        return head;

    }

    public static Node deleteAtLast(Node head) {
        if (head == null) {
            System.out.println("Head is empty");
            return null;
        }

        if (head.next == null) {
            return null;
        }
        Node secondLast = head;
        Node lastNode = head.next;

        while (lastNode.next != null) {  // means we reach to the lastnode.
            lastNode = lastNode.next;
            secondLast = secondLast.next;
        }
        secondLast.next = null;
        return head;

    }

    ////delete at position
    public static Node deleteAtPosition(Node head, int position) {
        if (head == null) {
            System.out.println("Head is empty");
            return null;
        }

        if (position==0) {
            head=head.next;
            return head;
        }

        int count = 0;
        Node temp = head;
        while (count < position - 1 && temp !=null) {
            count++;
            temp = temp.next;
        }
        if(temp ==null || temp.next==null){
            return head;
        }

        temp.next = temp.next.next;
        return head;
    }

    /////Print function
    public static void print(Node head) {
        if (head == null) {
            System.out.println("Head is empty");
            return;
        }

        Node curNode = head;
        while (curNode != null) {
            System.out.print(curNode.data + "->");
            curNode = curNode.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Node head = new Node(5);
        head.next = new Node(10);
        head.next.next = new Node(15);
        head.next.next.next = new Node(20);
        head.next.next.next.next = new Node(25);
        head.next.next.next.next.next = new Node(30);
        head.next.next.next.next.next.next = new Node(35);

        print(head);
        System.out.println("--------After Delete First Node------");
        Node deleteFirst = deleteAtStart(head);
        print(deleteFirst);
        System.out.println("--------After Delete last Node------");
        Node deleteAtLast = deleteAtLast(head);
        print(deleteAtLast);
        System.out.println("--------Delete at position------");
        Node deletePos = deleteAtPosition(head, 0);
        print(deletePos);
    }
}
