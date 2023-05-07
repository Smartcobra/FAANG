package Search_Element;

import create.CreateTree;
import create.Node;

public class FindElementRecursive {
    public static boolean isPresent(Node<Integer> root, int k) {
        if (root == null) {
            return false;
        }
        if (root.data == k) {
            return true;
        } else {
            isPresent(root.left, k);
            isPresent(root.right, k);
        }
        return false;
    }

    public static void main(String[] args) {
        CreateTree ct = new CreateTree();
        Node<Integer> root = ct.buildTree();

        System.out.println(isPresent(root, 11));
    }
}
