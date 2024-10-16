package Serialize_Deserialize_Binary_Tree;

import create.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
public class Codec {
    // Encodes a tree to a single string.
    private final String NN="X";
    private final String spliter=",";
    public String serialize(TreeNode root) {
        StringBuilder sb= new StringBuilder();
        serializeHelper(root,sb);
        return sb.toString();

    }

    private void serializeHelper(TreeNode root, StringBuilder sb) {
        if(root==null){
            sb.append(NN).append(spliter);
        }else{
            sb.append(root.val).append(spliter);
            serializeHelper(root.left,sb);
            serializeHelper(root.right,sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(spliter)));
        return  extractTree(queue);

    }

    private TreeNode extractTree(Queue<String> queue) {
        String val = queue.poll();
        if (val.equals(NN)){
            return null;
        }else{
            TreeNode node = new TreeNode(Integer.parseInt(val));
            node.left=extractTree(queue);
            node.right=extractTree(queue);
            return node;
        }

    }

    public static void main(String[] args) {

    }
}
