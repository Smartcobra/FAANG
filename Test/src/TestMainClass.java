public class TestMainClass {
    public static void main(String[] args) {
        int[] arr = {1,1,1,0,0,0,1,1,1,1,1,0,0,0,0,0,0};  ///0  // same length return first series
        System.out.println(getMaxLength(arr));;
    }

    public static int getMaxLength(int[] arr) {
        int ones=maxLengthOne(arr);
        int zeros=maxLengthZero(arr);

        if(ones>zeros) {
            return 1;
        } else {
            return 0;
        }

    }

    public static  int maxLengthOne(int[] arr) {
        int n = arr.length;
        int [] result= {};
        int ans = 0;
        int idx1=-1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                int count = 1;
                for (int j = i + 1; j < n && arr[j] == 1; j++) {
                    count++;
                }
                ans = Math.max(ans, count);
//                if(count>ans) {
//                    ans = count;
//                  //  idx1 = i;
//                }
            }
        }
       // result[0]=ans;
       // result[1]=idx1;
        return ans;
    }

    public static int maxLengthZero(int[] arr) {
        int [] result= {};
        int n = arr.length;
        int ans = 0;
        //int idx0=-1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                int count = 1;
                for (int j = i + 1; j < n && arr[j] == 0; j++) {
                    count++;
                }
                ans = Math.max(ans, count);
//                if(count>ans) {
//                    ans = count;
//                   // idx0 = i;
//                }
            }
           // result[0]=ans;
            //result[1]=idx0;
        }

        return ans;
    }
}





