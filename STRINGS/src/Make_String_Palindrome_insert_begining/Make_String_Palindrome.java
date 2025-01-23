package Make_String_Palindrome_insert_begining;
/*
Given a string A of size N consisting only of lowercase alphabets. The only operation allowed is to insert characters in the beginning of the string.

Find and return how many minimum characters are needed to be inserted to make the string a palindrome string.
 */
///https://www.scaler.com/academy/mentee-dashboard/class/29548/homework/problems/363/hints?navref=cl_pb_nv_tb
public class Make_String_Palindrome {

    public static int solve(String A) {
        String str=A;
        int n=str.length();
        int cnt = 0;
        boolean flag = true;

        while(n>0){
            if(isPalidrome(str)){
                flag=true;
                break;
            }else{
                cnt++;
              str=str.substring(0,str.length()-1);
            }
        }

        return flag?cnt:0;
    }

    public static boolean isPalidrome(String str){
        int s=0;
        int e=str.length()-1;

        while(s<e){
            if(str.charAt(s)!=str.charAt(e)){
              return false;
            }
            s++;
            e--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str="AACECAAAA";
        System.out.println(solve(str));
    }
}
