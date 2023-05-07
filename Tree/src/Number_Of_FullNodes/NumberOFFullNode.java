package Number_Of_FullNodes;

import create.CreateTree;
import create.Node;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOFFullNode {
    public static int getFullNodes(Node<Integer> root){
        int count=0;
        Queue<Node<Integer>> queue= new ArrayDeque<>();
        queue.add(root);
        Node curr=null;

        while(!queue.isEmpty()){
            curr=queue.poll();
            if(curr.left!=null && curr.right !=null){
                count++;
            }
            if(curr.left !=null){
                queue.add(curr.left);
            }
            if(curr.right !=null){
                queue.add(curr.right);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        CreateTree ct= new CreateTree();
        Node<Integer> root=ct.buildTree();
        System.out.println(getFullNodes(root));
    }
}
