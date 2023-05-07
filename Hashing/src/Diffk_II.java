import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
*
* Given an array A of integers and another non negative integer k, find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.
Example :
Input :
A : [1 5 3]
k : 2

Output :  1
as 3 - 1 = 2
Return 0 / 1 for this problem.

* */
public class Diffk_II {

    public static int diffPossible(final List<Integer> A, int B) {

        HashSet<Integer> set= new HashSet<>();

        for(int i=0;i<A.size();i++){
            int a=A.get(i);  //3
            int b=a+B; //63
            int c=a-B;

            if( set.contains(c) || set.contains(b)){
                return 1;
            }else{
                set.add(a);
            }
        }

        return 0;
    }

    public static void main(String[] args) {
//        List  value = Arrays.asList(11, 85, 100, 44, 3, 32, 96, 72, 93, 76, 67, 93, 63, 5, 10, 45, 99, 35, 13);
//        int B=60;
//        System.out.println(diffPossible(value,B));

        List  value = Arrays.asList( 77, 28, 19, 21, 67, 15, 53, 25, 82, 52, 8, 94, 50, 30, 37, 39, 9, 43, 35, 48, 82, 53, 16, 20, 13, 95, 18, 67, 77, 12, 93, 0 );
        int B=53;
        System.out.println(diffPossible(value,B));



    }
}
