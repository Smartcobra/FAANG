package Contact_Finder;
////https://www.scaler.com/academy/mentee-dashboard/class/35023/homework/problems/9384/?navref=cl_pb_nv_tb
import java.util.ArrayList;

class TrieNode {
    char c;
    TrieNode[] children;
    int count;
    boolean isEnd;

    TrieNode(char c, int count) {
        this.c = c;
        this.count = count;
        this.children = new TrieNode[26];
        this.isEnd = false;

    }

}

public class Contact_Finder {

    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<String> B) {
        ArrayList<Integer> result = new ArrayList<>();
        TrieNode root = new TrieNode('0', 1);

        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) == 0) {
                insert(root, B.get(i));
            }
            if (A.get(i) == 1) {
                int p = search(root, B.get(i));
                result.add(p);
            }
        }
        return result;
        /// return  prefixList.stream().mapToInt(i -> i).toArray();   to convert list to Array
    }

    public void insert(TrieNode root, String str) {
        TrieNode curr = root;
        int n = str.length();
        for (int i = 0; i < n; i++) {
            int idx = str.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode(str.charAt(i), 1);
            } else {
                curr.children[idx].count++;
            }
            curr = curr.children[idx];
        }
        curr.isEnd = true;

    }

    public int search(TrieNode root, String prefix) {
        TrieNode curr = root;
        int l = prefix.length();
        for (int i = 0; i < l; i++) {
            int idx = prefix.charAt(i);
            if (curr.children[idx] == null) {
                return 0;
            }
            curr = curr.children[idx];
        }
        return curr.count;
    }
}
