package sizeOfBinaryTree;

import create.CreateTree;
import create.Node;

import java.util.LinkedList;
import java.util.Queue;

public class FindSize {
    public static int getSize(Node<Integer> root){
        int count=0;
        Queue<Node<Integer>> queue= new LinkedList<>();
        queue.add(root);

        Node<Integer>  curr= null;

        while(!queue.isEmpty()){
            curr= queue.poll();
            count++;

            if(curr.left!=null){
                queue.add(curr.left);
            }
            if(curr.right!=null){
                queue.add(curr.right);
            }
        }
        return  count;
    }
    public static void main(String[] args) {
        CreateTree ct= new CreateTree();
        Node<Integer> root=ct.buildTree();
        System.out.println(getSize(root));
    }
}
