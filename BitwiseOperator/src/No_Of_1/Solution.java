package No_Of_1;

public class Solution {
    public int numSetBits(int A) {
        int count=0;

        for(int i=0;i<32;i++){
            if(checkBit(A,i)){
                count++;
            }
        }

        return count;
    }

    private boolean checkBit(int A,int i){
        if(((A>>i)&1)==1) return true;
        return false;
    }
}
