package TWO_Unique_In_ARRAY;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
* Given n elements in an array  every element repeated twice except 2 elenets . Find  the 2 unique elements
*
*
* */
public class Solution_HashMap {
    public static int[] getTwoUnique(int [] arr){
        int length=arr.length;
        int[] result= new int [2];
        int k=0;

        Map<Integer,Integer> map= new HashMap<Integer,Integer>();

        for (int j : arr) {
            map.put(j,map.getOrDefault(j,0)+1);
        }

        for (Map.Entry<Integer,Integer> m:map.entrySet()){
            if(m.getValue()==1){
                result[k++]=m.getKey();
            }
        }

        return result;

    }

    public static void main(String[] args) {
        int []arr= {3,6,4,4,3,8};
        System.out.println(Arrays.toString(getTwoUnique(arr)));
    }
}
