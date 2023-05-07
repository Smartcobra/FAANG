package Count_A;

public class CountA {
    public int solve(String A) {
        int len=A.length();
        int c_start=0;
        int c_end=0;

        for(int i=0;i<len;i++){
            if(A.charAt(i)=='a'){
                c_start++;
            }

            if(A.charAt(i)=='a'){
                c_end=c_end+c_start;
            }
        }

        return c_end;
    }
}
