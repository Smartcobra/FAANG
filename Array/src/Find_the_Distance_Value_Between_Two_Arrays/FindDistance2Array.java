package Find_the_Distance_Value_Between_Two_Arrays;
//https://leetcode.com/problems/find-the-distance-value-between-two-arrays/
public class FindDistance2Array {
    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int n1=arr1.length;
        int n2=arr2.length;
        int nonDistance=0;

        for(int i=0;i<n1;i++){
            for(int j=0;j<n2;j++){
                int td=Math.abs(arr1[i]-arr2[j]);
                if(td<=d){
                    nonDistance++;
                    /// we find a number here in arr1 which have a larger distance than d ,comparing to any element of arr2, so no need to move further
                    break;
                }
            }
        }

        return  n1-nonDistance;
    }

    public static void main(String[] args) {
        int[] arr1= {4,5,8};
        int[] arr2={10,9,1,8};
        int d=2;
        System.out.println(findTheDistanceValue(arr1,arr2,d));
    }
}
