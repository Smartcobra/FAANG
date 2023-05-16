package create;

public class CreateTree {
    public static Node<Integer> buildTree(){
        Node<Integer> root= new Node<>(17);

        Node<Integer> root_left= new Node<>(7);
        Node<Integer> root_right= new Node<>(5);

        Node<Integer> root_left_left= new Node<>(2);
        Node<Integer> root_left_right= new Node<>(6);

        Node<Integer> root_left_right_left= new Node<>(5);
        Node<Integer> root_left_right_right= new Node<>(11);

        Node<Integer> root_right_right= new Node<>(9);
        Node<Integer> root_right_right_left= new Node<>(4);

        root.left=root_left;
        root.right=root_right;

        root_left.left=root_left_left;
        root_left.right=root_left_right;

        root_left_right.left=root_left_right_left;
        root_left_right.right=root_left_right_right;

        root_right.right=root_right_right;
        root_right.right.left=root_right_right_left;

        return root;
    }

    public static Node<Integer> buildTree2(){
        Node<Integer> root= new Node<>(25);


        root.left=new Node<>(15);
        root.right=new Node<>(50);

        root.left.left= new Node<>(10);
        root.left.left.left= new Node<>(4);
        root.left.left.right= new Node<>(12);

        root.left.right=new Node<>(22);
        root.left.right.left=new Node<>(18);
        root.left.right.right=new Node<>(24);


        root.right.left=new Node<>(35);
        root.right.left.left=new Node<>(31);
        root.right.left.right=new Node<>(44);

        root.right.right=new Node<>(70);
        root.right.right.left=new Node<>(66);
        root.right.right.right=new Node<>(90);


        return root;
    }

    public static void main(String[] args) {
        CreateTree.buildTree();
    }
}
