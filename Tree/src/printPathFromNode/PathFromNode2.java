package printPathFromNode;

import create.CreateTree;
import create.Node;

import java.util.ArrayList;
import java.util.List;

//using ArrayList as return type
public class PathFromNode2 {
    public static List<Node<Integer>> getPath(Node<Integer> root, int data) {
        if (root == null) {
            return null;
        }
        if (root.data == data) {
            List<Node<Integer>> list = new ArrayList<>();
            list.add(root);
            return list;
        }

        List<Node<Integer>> listLeft = getPath(root.left, data);
        if (listLeft != null) {
            listLeft.add(root);
            return listLeft;
        }
        List<Node<Integer>> listRight = getPath(root.right, data);
        if (listRight != null) {
            listRight.add(root);
            return listRight;
        }

        return null;
    }

    public static List<Node<Integer>> getPathHelper(Node<Integer> root, int data) {
        List<Node<Integer>> res = getPath(root, data);
        return res != null ? res : new ArrayList<>();
    }

    public static void main(String[] args) {
        CreateTree ct = new CreateTree();
        Node<Integer> root = ct.buildTree();
        List<Node<Integer>> res = getPathHelper(root, 4);
        res.stream().forEach(System.out::print);

    }
}
