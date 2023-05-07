package Number_of_Subarrays_Sum_less_than_B;


public class CountingSubarrays {

//    Given an array A of N non-negative numbers and a non-negative number B,
//    you need to find the number of subarrays in A with a sum less than B.
//    We may assume that there is no overflow.

    public static int getCount(int [] arr, int target){
        int sum=0;
        int count=0;
        for (int i=0;i<arr.length;i++){
            sum=0;
            for(int j=i;j<arr.length;j++){
                sum=sum+arr[j];

                if(sum<=target){
                    count++;
                }
                System.out.println(sum +" ");

            }
        }
        return count;
    }

    public static void main(String[] args) {
        int []arr= {2, 5, 6};
        int B = 10;
        System.out.println(getCount(arr,B));
    }

}
