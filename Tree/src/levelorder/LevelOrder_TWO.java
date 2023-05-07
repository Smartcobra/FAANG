package levelorder;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder_TWO {
    public static void printLevelOrder(Node root){
        Queue<Node> queue= new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while(queue.size()>1){
            Node f=queue.peek();
            queue.remove();

            if(f==null){
                System.out.print("\n");
                queue.add(null);
            }else{
                System.out.print(f.data+"  ");
                if(f.left!=null){
                    queue.add(f.left);
                }
                if(f.right!=null){
                    queue.add(f.right);
                }
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
