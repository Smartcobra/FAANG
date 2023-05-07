package printPathFromNode;

import create.CreateTree;
import create.Node;

import java.util.ArrayList;
import java.util.List;

public class PathFromNode {
    public static List<Integer> printPathFromNode(Node<Integer> root, int data) {
        List<Integer> list = new ArrayList<>();
        printPathFromNode(root, list, data);
        return list;

    }

    private static boolean printPathFromNode(Node<Integer> root, List<Integer> path, int data) {
        if (root == null) {
            return false;
        }
        if (root.data == data) {
            path.add(root.data);
            return true;
        }

        boolean fil = printPathFromNode(root.left, path, data);
        if (fil) {
            path.add(root.data);
            return true;
        }
        boolean fir = printPathFromNode(root.right, path, data);
        if (fir) {
            path.add(root.data);
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        CreateTree ct = new CreateTree();
        Node<Integer> root = ct.buildTree();
        List<Integer> integers = printPathFromNode(root, 4);
        integers.stream().forEach(System.out::print);

    }
}
