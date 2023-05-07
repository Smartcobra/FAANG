package inorder;

import create.CreateTree;
import create.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrder_Non_Recursive {
    public static List<Integer> printInOrder(Node<Integer> root) {
        List<Integer> list = new ArrayList<>();

        Stack<Node> stack = new Stack<>();
        boolean done = false;
        Node<Integer> currentNode = root;

        while (!done) {
            if (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            } else {
                if (stack.isEmpty()) {
                    done = true;
                } else {
                    currentNode = stack.pop();
                    list.add(currentNode.data);
                    currentNode = currentNode.right;
                }
            }
        }

        return list;

    }

    public static void main(String[] args) {
        Node<Integer> node = CreateTree.buildTree();
        List<Integer> integers = printInOrder(node);
        integers.stream().forEach(t-> System.out.print(t+"->"));
    }
}
