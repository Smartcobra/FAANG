package Modified_Search;

import java.util.ArrayList;
import java.util.HashMap;

class TrieNode {
    HashMap<Character, TrieNode> childMap = new HashMap<>();
    boolean isEnd = false;
}
//////https://www.scaler.com/academy/mentee-dashboard/class/35023/homework/problems/5832/?navref=cl_pb_nv_tb
public class ModifiedSearch {
    public static String solve(ArrayList<String> A, ArrayList<String> B) {
        int a = A.size();
        int b = B.size();
        StringBuilder result = new StringBuilder();
        TrieNode root = new TrieNode();

        for (String value : A) {
            insert(value, root);
        }

        for (String s : B) {
            result.append(search(s, root, false, 0) ? 1 : 0);
        }

        return result.toString();
    }

    public static void insert(String str, TrieNode root) {
        int n = str.length();
        for (char c : str.toCharArray()) {
            if (!root.childMap.containsKey(c)) {
                TrieNode tmp = new TrieNode();
                root.childMap.put(c, tmp);
                root = tmp;
            } else {
                root = root.childMap.get(c);
            }
        }
        root.isEnd = true;

    }

    public static boolean search(String str, TrieNode root, boolean isModified, int index) {
        int size = str.length();

        if (index == size && isModified && root.isEnd) {
            return true;
        }
        if (index >= size) return false;

        char key = str.charAt(index);

        if (isModified) {
            if (root.childMap.containsKey(key)) {
                return search(str, root.childMap.get(key), isModified, index + 1);
            }
        } else {
            for (char ch : root.childMap.keySet()) {
                if (ch == key) {
                    if (search(str, root.childMap.get(ch), isModified, index + 1)) {
                        return true;
                    }
                } else {
                    if (search(str, root.childMap.get(ch), true, index + 1)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }


    public static void main(String[] args) {

        ArrayList<String> A = new ArrayList<>();
        A.add("data");
        A.add("circle");
        A.add("cricket");

        ArrayList<String> B = new ArrayList<>();
        B.add("date");
        B.add("circel");
        B.add("crikket");
        B.add("data");
        B.add("circl");

        System.out.println(solve(A, B));
    }
}
