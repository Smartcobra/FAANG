package Equal_Tree_Partition;


import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}
//https://www.scaler.com/academy/mentee-dashboard/class/35021/assignment/problems/4859/?navref=cl_pb_nv_tb
public class Equal_Tree_Partition {
   static  HashMap<TreeNode, Integer> map = new HashMap<>();
///for big values use long
    public static int solve(TreeNode A) {
        int sum=sum(A);
        for (Map.Entry<TreeNode, Integer> m : map.entrySet()) {
            System.out.println("key:: "+m.getKey().val + "   val:: "+m.getValue());
           if(m.getValue()==sum/2) return 1;
        }
        return 0;
    }

    public static int sum(TreeNode root) {
        if (root == null) return 0;
        int sum_left = sum(root.left);
        int sum_right = sum(root.right);
        int cur_sum = root.val + sum_left + sum_right;
        map.put(root, cur_sum);
        return map.get(root);
    }

    public static void main(String[] args) {
        /*
        *        5
               /  \
              3    7
             / \  / \
            4  6  5  6

        * */
        TreeNode root= new TreeNode(5);
        root.left= new TreeNode(3);
        root.right=new TreeNode(7);

        root.left.left=new TreeNode(4);
        root.left.right= new TreeNode(6);

        root.right.left=new TreeNode(5);
        root.right.right=new TreeNode(6);
       // System.out.println(sum(root));

        System.out.println( solve(root));

    }
}
