package Check_for_BST_with_One_Child;


import java.util.ArrayList;

public class Check_for_BST_with_One_Child {
    public String solve(ArrayList<Integer> A) {
        int L=Integer.MIN_VALUE;
        int R=Integer.MAX_VALUE;
        int root=A.get(0);

        for(int i=1;i<A.size();i++){
            if(A.get(i)>root){
                L=root;
            }else{
                R=root;
            }

            if(A.get(i)<L || A.get(i)>R){
                return "NO";
            }
            root=A.get(i);
        }
        return "YES";
    }
}
