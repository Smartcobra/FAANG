package Number_Of_Leaves;

import create.CreateTree;
import create.Node;

import java.util.ArrayDeque;
import java.util.Queue;

public class FindNumberOfLeaves {
    public static int getNumberOFLeaves(Node<Integer> root){
        Queue<Node<Integer>> queue= new ArrayDeque<>();
        Node<Integer> curr=null;
        queue.add(root);
        int count=0;

        while(!queue.isEmpty()){
            curr=queue.poll();
            if(curr.left==null &&curr.right==null){
                count++;
            }
            if(curr.left!=null){
                queue.add(curr.left);
            }
            if(curr.right!=null){
                queue.add(curr.right);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CreateTree ct= new CreateTree();
        Node<Integer> root=ct.buildTree();
        System.out.println(getNumberOFLeaves(root));
    }
}
