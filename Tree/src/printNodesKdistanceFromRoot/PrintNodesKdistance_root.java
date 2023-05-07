package printNodesKdistanceFromRoot;
//Given a root of a tree, and an integer k. Print all the nodes which are at k distance from root.  For example, in the below tree, 4, 5 & 8 are at distance 2 from root.


import create.CreateTree;
import create.Node;

public class PrintNodesKdistance_root {
    public static void printNodesKDistance(Node<Integer> root,int k){
        if(root==null){
            return;
        }
        if (k==0){
            System.out.println(root.data);
            return;
        }else{
            printNodesKDistance(root.left,k-1);
            printNodesKDistance(root.right,k-1);
        }
    }

    public static void main(String[] args) {
        CreateTree ct= new CreateTree();
        Node<Integer> root=ct.buildTree();
        printNodesKDistance(root,3);
    }
}
