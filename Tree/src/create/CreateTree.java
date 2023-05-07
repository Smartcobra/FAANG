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

    public static void main(String[] args) {
        CreateTree.buildTree();
    }
}
