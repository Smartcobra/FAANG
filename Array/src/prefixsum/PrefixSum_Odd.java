package prefixsum;

import java.util.Arrays;

public class PrefixSum_Odd {
    public static int[] getPrefixSum_Odd(int [] arr){
        int n=arr.length;

        int [] prefixArr= new int[n];
        prefixArr[0]=arr[0];
        prefixArr[1]=arr[1];
        for(int i=2;i<n;i++){
            if(i%2==1){
                prefixArr[i]=arr[i]+prefixArr[i-1];
            }else{
                prefixArr[i]=prefixArr[i-1];
            }
        }
       return  prefixArr ;
    }

    public static void main(String[] args) {
        int [] arr= {2,-1,3,1,4,3,2,-1};
        int [] result= getPrefixSum_Odd(arr);
        Arrays.stream(result).forEach(r->System.out.print(r+" "));
    }

}
