package Spelling_Checker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Node {
    boolean isEnd;
    HashMap<Character,Node> map = new HashMap<>();

    Node() {
        isEnd = false;
    }
}

public class SpellingChecker {

    public static ArrayList<Integer> solve(ArrayList<String> A, ArrayList<String> B) {

        int n = A.size();
        Node root = new Node();
        for (int i = 0; i < n; i++) {
            insert(A.get(i), root);
        }

        int m = B.size();
        ArrayList<Integer> result = new ArrayList<>( Collections.nCopies(m, 0));
        for (int i = 0; i < m; i++) {
            if (search(B.get(i), root)) {
                result.set(i, 1);
            }

        }

        return result;
    }

    public static void insert(String word, Node root) {
        int len = word.length();
        for (int i = 0; i < len; i++) {
            char c = word.charAt(i);
            if (!root.map.containsKey(c)) {
                Node tmp = new Node();
                root.map.put(c, tmp);
                root = tmp;
            } else {
                root = root.map.get(c);
            }
        }
        root.isEnd = true;
    }

    public static boolean search(String word, Node root) {
        int len = word.length();

        for (int i = 0; i < len; i++) {
            char c = word.charAt(i);
            if (!root.map.containsKey(c)) {
                return false;
            } else {
                root = root.map.get(c);
            }
        }
        return root.isEnd;
    }

    public static void main(String[] args) {
        //String [] A = { "a", "b" };
        ArrayList<String> A = new ArrayList<>();
        A.add("a");
        A.add("b");
        // String [] B = { "a", "b" };
        ArrayList<String> B = new ArrayList<>();
        B.add("a");
        B.add("b");
//
//        A : [ "a", "b" ]
//        B : [ "a", "c" ]
        System.out.println(solve(A, B));
    }
}

