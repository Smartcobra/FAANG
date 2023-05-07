package minimum_Number_Of_jumps;

public class MinJumps_recursive {
    public static int minJumps(int arr[] ,int start, int end){
        if(start>=end){
            return 0;
        }
        int min=Integer.MAX_VALUE;

        for(int i=1;i<=arr[start] && i<end ;i++ ){
            int minJumps=1+minJumps(arr,start+i,end);
            if(minJumps<min){
                min=minJumps;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, 6, 3, 2, 3, 6, 8, 9, 5 };
        int n = arr.length;
        System.out.print("Minimum number of jumps to reach end is "
                + minJumps(arr, 0, n - 1));
    }
}
