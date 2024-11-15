package inorder_traversal;

import create.CreateTree;
import create.Node;

public class InOrder_Recursive {
    public static void print_InOrder(Node<Integer> node){
        if(node == null){
            return;
        }

        print_InOrder(node.left);
        System.out.print(node.data+"->");
        print_InOrder(node.right);
    }

    public static void main(String[] args) {
        Node<Integer> node = CreateTree.buildTree();
        print_InOrder(node);
    }
}
