package Delete_Node_From_BinaryTree;

import create.Node;

import java.util.ArrayDeque;
import java.util.Queue;

public class DeleteNode {
    public static Node<Integer>  deleteDeepest(Node<Integer> root){

        Queue<Node<Integer>> queue = new ArrayDeque<>();
        queue.add(root);
        Node<Integer> curr=null;

        while (!queue.isEmpty()){
            curr=queue.poll();
           //if(curr)
        }
 return null;
    }
}
