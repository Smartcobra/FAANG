package Print_Path_From_Root;

import create.CreateTree;
import create.Node;

public class PrintPath {
    public static void printPath(Node<Integer> root){
        int path[]= new int [256];
        printPath(root,path,0);

    }

    private static void printPath(Node<Integer> root, int[] path, int len) {
        if(root==null){
            return;
        }
        path[len]=root.data;
        len++;

        //if leaf node print
        if(root.left==null && root.right==null){
            printArray(path,len);
        }else{
            printPath(root.left,path,len);
            printPath(root.right,path,len);
        }

    }

    private static void printArray(int[] path, int len) {
        for(int i=0;i<len;i++){
            System.out.print(path[i]+"->");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        CreateTree ct= new CreateTree();
        Node<Integer> root=ct.buildTree();
        printPath(root);
    }
}
