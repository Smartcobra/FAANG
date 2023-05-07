package minimum_Number_Of_jumps;

public class MinimumJump_Greedy {
    public static int minJumps(int[] arr) {
        int n = arr.length;
        int far_jump = 0;  // max jump can be done
        int curr_end = 0;
        int ans = 0;
        if (n == 1) return 0;  // if array contains 1 element we need 0 jump;

        for (int i = 0; i < n; i++) {
            far_jump = Math.max(far_jump, i + arr[i]);

            if (i == curr_end) {
                ans++;
                curr_end = far_jump;
                if (curr_end == n - 1) break;  // if we reach then end no need to calculate more
            }

            /*
            *  can be written
            * if (i == curr_end && curr_end != n - 1) {
                ans++;
                curr_end = far_jump;
            }else{
             break;
            *
            *
            * */
        }

        return ans;

    }


    public static void main(String[] args) {
        int[] arr = {0};
        System.out.println(minJumps(arr));
    }
}
