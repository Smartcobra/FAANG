package levelorder;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Reverse_Level_Order {
    public static void reverseLevel(Node root){
        if (root == null) {
            return;
        }
        Queue<Node> queue =  new ArrayDeque<>();
        Stack<Node> stack = new Stack<>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node cur= queue.poll();
           // System.out.println(cur.data);
            stack.push(cur);



            if(cur.left!=null){
                queue.add(cur.left);
            }
            if(cur.right!=null){
                queue.add(cur.right);
            }
        }

        while (!stack.isEmpty()){
            Node cur=stack.pop();
            System.out.print(cur.data );
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

        reverseLevel(root);
    }
}
