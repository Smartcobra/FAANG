package Recover_Binary_Search_Tree;

import java.util.ArrayList;

public class Recover_BST {

    public static  ArrayList<Integer> recoverTree(TreeNode root) {
        ArrayList<Integer> list = morrisInorder(root);
        ArrayList<Integer> tmp= new ArrayList<>();
        ArrayList<Integer> result= new ArrayList<>();

        for(int i=0;i<list.size()-1;i++){
            if(list.get(i)>list.get(i+1)){
                //System.out.println(list.get(i));
               // System.out.println(list.get(i+1));
                tmp.add(list.get(i));
                tmp.add(list.get(i+1));
            }
        }
        result.add(tmp.get(0));
        result.add(tmp.get(3));
        return result;
    }

    public static ArrayList<Integer> morrisInorder(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
                result.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }
                //if null give connection
                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                } else {   //disconnect
                    prev.right = null;
                    result.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(25);
        root.left.left.left = new TreeNode(1);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(9);
        root.right.left = new TreeNode(20);
        root.right.right = new TreeNode(30);
        root.right.right.left = new TreeNode(28);
        root.right.right.right = new TreeNode(35);

        System.out.println(morrisInorder(root));
        System.out.println(recoverTree(root));
    }
}
