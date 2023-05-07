package otherStringAlgo;

public class CheckDivisible {

    public static boolean isDivisible(String str,int k){

        Long num=Long.parseLong(str);
        if(num%k==0){
            return true;
        }

        return false;
    }

    public static int isDivisibleFromIndex(String str,int k){

            int index=0;
            for(int i=0;i<str.length();i++){
                Long num=Long.parseLong(str.substring(i));

                if(num%k==0){
                    index= i;
                    System.out.println(str.substring(0,index));

                }
        }



        return index;
    }

    public static void main(String[] args) {
        //System.out.println(isDivisible("1112121",7));
        System.out.println(isDivisibleFromIndex("1112121",7));

    }
}
