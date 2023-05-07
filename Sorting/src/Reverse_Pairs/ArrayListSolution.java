package Reverse_Pairs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListSolution {
    public static int solve(List<Integer> A) {
        int s=0;
        int e=A.size()-1;
        return mergeSort(A,s,e);
    }
    public static int mergeSort(List<Integer> arr,int s,int e){
        if(s==e) return 0;
        int m=(s+e)/2;
        int l=mergeSort(arr,s,m);
        int r=mergeSort(arr,m+1,e);

        return l+r+merge(arr,s,m,e);
    }

    public static int merge(List<Integer> arr,int s,int m,int e){
        int p1=s;
        int p2=m+1;
        int count=0;
        List<Integer> tmp= new ArrayList<>();

        while(p1<=m && p2<=e){
            if((long)arr.get(p1)>(2L *arr.get(p2))){
                p2++;
                count += m-p1+1;
            }else{
                p1++;
            }
        }
        p1=s;p2=m+1;
        while(p1<=m && p2<=e){
            if(arr.get(p1)>arr.get(p2)){
                tmp.add(arr.get(p2));
                p2++;
            }else{
                tmp.add(arr.get(p1));
                p1++;
            }
        }

        while(p2<=e){
            tmp.add(arr.get(p2));
            p2++;
        }

        while(p1<=m){
            tmp.add(arr.get(p1));
            p1++;
        }

        for(int i=0;i<=e-s;i++){
            arr.set(s+i,tmp.get(i));
        }

        return count;
    }

    public static void main(String[] args) {
        List<Integer> l= Arrays.asList( 14046, 57239, 78362, 99387, 27609, 55100, 65536, 62099,
                40820, 33056, 88380, 78549, 57512, 33137, 81212, 32365, 42276, 65368, 52459, 74924,
                25355, 76044, 78056, 45190, 94365, 58869, 20611 );
        List<Integer>l1= Arrays.asList(1, 3, 2, 3, 1);
        System.out.println(solve(l));
    }

}
