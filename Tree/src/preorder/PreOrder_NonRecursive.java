package preorder;

import java.util.Stack;
class TreeNode{
    int data;
    TreeNode left=null;
    TreeNode  right=null;

    TreeNode(int data){
        this.data=data;
    }
}
public class PreOrder_NonRecursive {
    public static void print_Preorder(TreeNode root){
        Stack<TreeNode> stack= new Stack<TreeNode>();
        stack.push(root);
        TreeNode curr=null;
        while(!stack.isEmpty()){
            curr=stack.pop();
            System.out.print(curr.data +"->");

            if(curr.right !=null){
                stack.push(curr.right);
            }
            if(curr.left !=null){
                stack.push(curr.left);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(7);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(5);
        root.left.right.right= new TreeNode(11);

        root.right.right = new TreeNode(9);
        root.right.right.left = new TreeNode(4);
        print_Preorder(root);
    }
}
