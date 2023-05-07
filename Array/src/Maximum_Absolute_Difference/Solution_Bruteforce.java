package Maximum_Absolute_Difference;


public class Solution_Bruteforce {

    public static int maxArr(int[] A) {
        int n=A.length;
        int max= Integer.MIN_VALUE;
        int sum=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sum=Math.abs(A[i]-A[j])+ Math.abs(i-j);
                max=Math.max(max,sum);
            }
        }
        return max;
    }

    public static void main(String[] args) {
      //  int [] A = {1, 3, -1};
        int [] A={2};
        System.out.println(maxArr(A));

    }
}
