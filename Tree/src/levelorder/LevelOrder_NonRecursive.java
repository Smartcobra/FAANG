package levelorder;

import java.util.ArrayDeque;
import java.util.Queue;

class Node{
    int data;
    Node left=null;
    Node right=null;

    Node(int data){
        this.data=data;
    }
}
public class LevelOrder_NonRecursive {
    public static void printLevelOrder(Node root){

        Queue<Node> queue= new ArrayDeque<>();
        queue.add(root);


        while (!queue.isEmpty()){
            Node curr=queue.poll();
            System.out.print(curr.data+" ");

            if(curr.left !=null){
                queue.add(curr.left);
            }
            if(curr.right !=null){
                queue.add(curr.right);
            }
        }

    }

    public static void main(String[] args) {
        Node root = new Node(15);
        root.left = new Node(10);
        root.right = new Node(20);
        root.left.left = new Node(8);
        root.left.right = new Node(12);
        root.right.left = new Node(16);
        root.right.right = new Node(25);

        printLevelOrder(root);
    }
}
