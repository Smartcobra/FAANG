package Trapping_Rain_Water;

/////https://leetcode.com/problems/trapping-rain-water/
public class TrappingRainWater {
    public int trap(int[] height) {
      int n= height.length;
      int[] leftMax=new int[n];
      int[] rightMax=new int[n];
      int[] w= new int[n];
      int result=0;

      //find leftmax
        int left=0;
        for(int i=0;i<n;i++){
            leftMax[i]=left;
            left=Math.max(left,height[i]);
        }

        int right=0;
        for(int i=n-1;i>=0;--i){
            rightMax[i]=right;
            right=Math.max(right,height[i]);
        }

        for(int i=0;i<n;i++){
            int minHeight= Math.min(leftMax[i],rightMax[i]);
            if(height[i]<minHeight){
                w[i]=minHeight-height[i];
            }else{
                w[i]=0;
            }

            result +=w[i];
        }
    return  result;
    }
}
