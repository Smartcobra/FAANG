package Majority_Element_II;

import java.util.ArrayList;
import java.util.List;

public class OptimalSolution {
    public List<Integer> majorityElement(int[] nums) {
        int cnt1=0;
        int cnt2=0;
        int ele1=0;
        int ele2=0;
        List<Integer> result= new ArrayList<>();

        for(Integer num :nums){
            if(cnt1==0 && ele2 !=num){
                cnt1=1;
                ele1=num;
            }else if(cnt2==0 && ele1 !=num){
                cnt2=1;
                ele2= num;
            } else if (ele2 == num) {
                cnt2++;

            } else if (ele1 ==num) {
                cnt1++;
            }else{
                cnt1--; cnt2--;
            }
        }

        cnt1=0; cnt2=0;

        for(Integer num:nums){
            if(num==ele2) cnt2++;
            if(num==ele1) cnt1++;
        }

        if(cnt1 >=nums.length/3+1) result.add(ele1);
        if(cnt2 >=nums.length/3+1) result.add(ele2);

       return result;
    }
}
