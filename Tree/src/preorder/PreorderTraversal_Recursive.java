package preorder;

class Node{
    int data;
    Node left=null;
    Node right=null;

    Node(int data){
        this.data=data;
    }
}
public class PreorderTraversal_Recursive {
    public static void print_Preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+"->");
        print_Preorder(root.left);
        print_Preorder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(2);
        root.left = new Node(7);
        root.right = new Node(5);
        root.left.left = new Node(2);
        root.left.right = new Node(6);
        root.left.right.left = new Node(5);
        root.left.right.right= new Node(11);

        root.right.right = new Node(9);
        root.right.right.left = new Node(4);
        print_Preorder(root);
    }
}
