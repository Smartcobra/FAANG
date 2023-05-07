package Maximum_Element;

import create.CreateTree;
import create.Node;

public class FindMaximumElement_Recursive {
    public static int getMaxElement(Node<Integer> root){
        if(root ==null){
            return Integer.MIN_VALUE;
        }
        int max;
        int left_Max=getMaxElement(root.left); //left side max
        int right_Max=getMaxElement(root.right);  //right side max

        if(left_Max>right_Max){
            max=right_Max;
        }else{
            max=left_Max;
        }
        if(root.data>max){
            max=root.data;
        }
        return max;
    }

    public static void main(String[] args) {
        CreateTree ct= new CreateTree();
        Node<Integer> root=ct.buildTree();
        System.out.println(getMaxElement(root));
    }
}
