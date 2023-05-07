package Power;

public class Solution2 {

    public static int pow(int A, int B, int C) {
        if(A==0) return 0;
        if(B==0) return 1;

        long y= pow(A,B/2,C);

        if((B&1)==0){
            return (int) (( y%C * y%C )+C)%C;
        }else{
            return  (int)((y%C * y%C * A%C )+C)%C;
        }

    }

    public static void main(String[] args) {
        int A = 71045970;
        int B = 41535484;
        int C = 64735492;

        System.out.println(pow(A,B,C));

    }
}
