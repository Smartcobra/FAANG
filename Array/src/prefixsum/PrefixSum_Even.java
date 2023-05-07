package prefixsum;

import java.util.Arrays;

public class PrefixSum_Even {

    public static int [] getPrefixSumEven(int[] arr){
        int n= arr.length;

        int [] prefixArr=new int[n];
        prefixArr[0]=arr[0];

        for(int i=1;i<n;i++){
            if(i%2==0){
                prefixArr[i]=arr[i]+prefixArr[i-1];
            }else{
                prefixArr[i]=prefixArr[i-1];
            }
        }
        return prefixArr;
    }

    public static void main(String[] args) {
        int [] arr= {2,-1,3,1,4,3,2,-1};
        int [] result= getPrefixSumEven(arr);
        Arrays.stream(result).forEach(r->System.out.print(r+""));
    }
}
