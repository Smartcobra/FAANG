package construct_Tree_From_PreOrder_InOrder;

import create.Node;

import java.util.ArrayList;

public class Solution {
    private static int idx;
    public static Node<Integer> buildTree( ArrayList<Integer> preorder,ArrayList<Integer> inorder) {
        int inorder_start=0;
        int inorder_end=inorder.size()-1;
        idx=0;

        return buildTree_Helper(preorder,inorder,inorder_start,inorder_end);
    }

    public static Node<Integer> buildTree_Helper( ArrayList<Integer> preorder,ArrayList<Integer> inorder, int inorder_start,int inorder_end) {
        if(inorder_start>inorder_end) return null;

        int val=preorder.get(idx);
        Node<Integer> curr= new Node<>(val);
        idx++;
        if(inorder_start==inorder_end) return curr;

        int pos=search(inorder,inorder_start,inorder_end,val);

        curr.left=buildTree_Helper(preorder,inorder,inorder_start,pos-1);
        curr.right=buildTree_Helper(preorder,inorder,pos+1,inorder_end);

        return curr;
    }

    public static int search(ArrayList<Integer> inorder,int inorder_start,int inorder_end,int val){
        for(int i=inorder_start;i<=inorder_end;i++){
            if(inorder.get(i)==val){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

//        int[] inorder = {1, 2, 3, 4, 5 };
//        int[] preorder = {3, 2, 4, 1, 5 };
//
//        Node root = buildTree(inorder,preorder);

        // traverse the constructed tree
        System.out.print("The inorder traversal is ");
       // inOrderTraversal(root);

        System.out.print("\nThe preorder traversal is ");
       // preOrderTraversal(root);
    }
}
