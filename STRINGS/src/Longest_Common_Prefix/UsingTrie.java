package Longest_Common_Prefix;

import java.util.HashMap;
import java.util.Map;

///////https://leetcode.com/problems/longest-common-prefix/solution/
public class UsingTrie {
    public static String longestCommonPrefix(String[] strs) {
        TrieNode head = new TrieNode();
        for (String str : strs) {
            insert(str, head);
        }
        /**
         * curr.map.size()==1 means there is a different letter starts
         *
         * {"flower","flow","flight"}
         *  f ->l -> o
         *        -> i
         *
         *        from here no common prefix
         */

        StringBuilder sb = new StringBuilder();
        TrieNode curr = head;
        while (curr != null && !curr.isEnd && (curr.map.size()==1) ) {
            for (Map.Entry<Character, TrieNode> entry : curr.map.entrySet()) {
                sb.append(entry.getKey());
                curr = entry.getValue();
            }

        }
        return sb.toString();
    }

  //  && (curr.character.size() == 1)

    public static void insert(String str, TrieNode root) {
        TrieNode curr = root;

        for (Character c : str.toCharArray()) {
            curr.map.putIfAbsent(c, new TrieNode());
            curr = curr.map.get(c);
        }
        curr.isEnd = true;

    }

    public static void main(String[] args) {
        String [] str= {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(str));
    }

}

class TrieNode {
    boolean isEnd;
    Map<Character, TrieNode> map = new HashMap<>();
}