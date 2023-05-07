package No_Of_Distinct_Elemnts;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution4 {

    public static  ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        int n=A.size();

        ArrayList<Integer> result= new ArrayList<>();
        HashMap<Integer,Integer> map= new HashMap<>();

        for(int i=0;i<B;i++){
            map.put(A.get(i),map.getOrDefault(A.get(i),0)+1);
        }
        result.add(map.size());

        for(int i=B;i<n;i++){
            if(map.get(A.get(i-B))==1){
                map.remove(A.get(i-B));
            }else{
                int val=map.get(A.get(i-B));
                map.put(A.get(i-B),val-1);
            }
            map.put(A.get(i),map.getOrDefault(A.get(i),0)+1);

            result.add(map.size());
        }

        return result;
    }

    public static void main(String[] args) {


        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(3);
        int k=3;
        ArrayList<Integer> integers = dNums(list, k);
        integers.forEach(System.out::println);

    }
}
