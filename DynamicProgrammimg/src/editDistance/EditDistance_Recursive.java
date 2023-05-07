package editDistance;

public class EditDistance_Recursive {
    public static int min(int x,int y,int z){
        if(x<y && x<z){
            return x;
        }else if(y<x && y<z){
            return y;
        }else{
            return z;
        }
    }
    public static int getDistance(String str1,String str2,int m,int n){

        if(m==0){
            return n;
        }
        if(n==0){
            return m;
        }
        if(str1.charAt(m-1)==str2.charAt(n-1)){
            return getDistance(str1,str2,m-1,n-1);
        }else{
            return 1+min(getDistance(str1,str2,m,n-1),//insert
                    getDistance(str1,str2,m-1,n),//remove
                    getDistance(str1,str2,m-1,n-1));//replace
        }
    }

    public static void main(String[] args) {
        String str1 = "sunday";
        String str2 = "saturday";

        System.out.println(getDistance(
                str1, str2, str1.length(), str2.length()));
    }
}
