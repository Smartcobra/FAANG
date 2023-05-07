package Shortest_Unique_Prefix;


import java.util.Arrays;
import java.util.HashMap;

class TrieNode {
    int frequency;
    HashMap<Character, TrieNode> map = new HashMap<>();

}

public class Shortest_Unique_Prefix {

    public static  String[] prefix(String[] A) {
        String[] output = new String[A.length];
        TrieNode root = new TrieNode();

        for (int i = 0; i < A.length; i++) {
            insert(A[i], root);
        }

        for (int i = 0; i < A.length; i++) {
            output[i] = search(A[i], root);
        }

        return output;

    }

    public static void insert(String word, TrieNode root) {
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if (!root.map.containsKey(c)) {
                TrieNode tmp = new TrieNode();
                root.map.put(c, tmp);
                root.frequency++;
                root = tmp;
            } else {
                root.frequency++;
                root = root.map.get(c);
            }
        }
    }

    public static String search(String word, TrieNode root) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (root.frequency == 1) {
                return sb.toString();
            } else {
                sb.append(c);
                root = root.map.get(c);
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String[] A = {"zebra", "dog", "duck", "dove"};
        System.out.println(Arrays.toString(prefix(A)));
    }
}
