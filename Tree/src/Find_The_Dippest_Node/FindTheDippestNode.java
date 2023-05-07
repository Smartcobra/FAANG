package Find_The_Dippest_Node;

import create.CreateTree;
import create.Node;

import java.util.ArrayDeque;
import java.util.Queue;

public class FindTheDippestNode {
    public static Node<Integer>  getlastNodeNode(Node<Integer> root){
        Queue<Node<Integer>> queue= new ArrayDeque<>();
        queue.add(root);
        Node<Integer> curr=null;

        while(!queue.isEmpty()){
            curr=queue.poll();

            if(curr.left !=null){
                queue.add(curr.left);
            }
            if(curr.right !=null){
                queue.add(curr.right);
            }

        }
        return curr;
    }

    public static void main(String[] args) {
        CreateTree ct= new CreateTree();
        Node<Integer> root=ct.buildTree();
        Node<Integer> integerNode = getlastNodeNode(root);
        System.out.println(integerNode.data);
    }

}
