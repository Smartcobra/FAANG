package Insert;


import node.Node;

public class InsertData {

    public static Node insertFirst(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        }
        newNode.next = head;
        head = newNode;
        return head;
    }

    public static Node insertLast(Node head, int data){

        Node newNode=new Node(data);
        if (head == null) {
            head = newNode;
        }

        Node currentNode= head;
        if(currentNode.next !=null){
            currentNode=currentNode.next;
        }
        currentNode.next=newNode;
        return head;
    }

    public  static void print(Node head){

        Node curNode =head;
        while(curNode !=null){
            System.out.print(curNode.data +"-->");
            curNode=curNode.next;
        }
    }

    public static void main(String[] args) {
        Node head=new Node(2);
//        Node node = insertFirst(head, 3);
//        print(node);

        Node nodelast = insertLast(head, 5);
        print(nodelast);


    }

}
