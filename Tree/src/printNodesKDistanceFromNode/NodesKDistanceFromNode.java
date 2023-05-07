package printNodesKDistanceFromNode;

import create.Node;

import java.util.ArrayList;
import java.util.List;

public class NodesKDistanceFromNode {

    public static void printNodesKDistanceFromNode(Node<Integer> root, int data, int k) {
        List<Node<Integer>> pathFromNode = getPathFromNode(root, data);
        for (int i = 0; i < pathFromNode.size(); i++) {
            printKLevelNodesDown(pathFromNode.get(i), k - i, i == 0 ? null : pathFromNode.get(i - 1));
        }
    }


    // to get path from specific node to root
    public static List<Node<Integer>> getPathFromNode(Node<Integer> root, int data) {
        List<Node<Integer>> list = getPathFromNodeHelper(root, data);
        return list;
    }

    private static List<Node<Integer>> getPathFromNodeHelper(Node<Integer> root, int data) {
        if (root == null) {
            return null;
        }
        if (root.data == data) {
            List<Node<Integer>> list = new ArrayList<>();
            list.add(root);
            return list;
        }
        List<Node<Integer>> leftList = getPathFromNodeHelper(root.left, data);
        if (leftList != null) {
            leftList.add(root);
            return leftList;
        }
        List<Node<Integer>> rightList = getPathFromNodeHelper(root.right, data);
        if (rightList != null) {
            rightList.add(root);
            return rightList;
        }

        return null;

    }

    ///to print klevel down
    public static void printKLevelNodesDown(Node<Integer> node, int k, Node<Integer> blockNode) {
        if (node == null || node == blockNode || k < 0) {
            return;
        }
        if (k == 0) {
            System.out.println(node.data);
        }
        printKLevelNodesDown(node.left, k - 1, blockNode);
        printKLevelNodesDown(node.right, k - 1, blockNode);
    }
}
