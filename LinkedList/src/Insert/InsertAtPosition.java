package Insert;

import node.Node;

public class InsertAtPosition {

    public static void print(Node head){

        Node tmp= head;
        while(tmp != null){
            System.out.print(tmp.data + "->");
            tmp=tmp.next;
        }
    }

    public static Node insertAtPosition(Node head, int position, int data) {
        Node newNode = new Node(data);

        if (position == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            int count = 0;
            Node prev = head;

            while (count < position - 1 && prev != null) {
                count++;
                prev = prev.next;
            }

            if (prev != null) {
                newNode.next = prev.next;
                prev.next = newNode;
            }
        }


        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(2);
        Node one = new Node(3);
        head.next=one;
        Node two = new Node(80);
        one.next=two;
        Node three = new Node(56);
        two.next=three;
        Node four = new Node(900);
        three.next=four;

        Node node = insertAtPosition(head, 3, 1);
        print(node);
    }
}
