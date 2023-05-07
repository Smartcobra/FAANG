package knapsack.fraction;

import java.util.Arrays;

public class GreedyFractionKnapsack {
    public int getMaxProfit(int [][] item,int W){
        int len=item.length;
        System.out.println("len->"+len);
        Arrays.sort(item,(a,b)->b[0]/b[1]-a[0]/a[1]);

          double x[] = new double [len];
          int weight=0;
         for(int i=0;i<len;i++){
             //System.out.println(item[i][1]);
             if(weight+item[i][1]<=W){
                 x[i]=1;
                 weight+=item[i][1];
             }else{
                 double fraction
                         = ((double)(W-weight) / (double)item[i][1]);
                 x[i]=fraction;
                 weight=W;
                 break;
             }
         }
      Arrays.stream(x).forEach(z->System.out.print(z+" ,"));

        return 0;
    }

    public static void main(String[] args) {
        GreedyFractionKnapsack gfk= new GreedyFractionKnapsack();
        int[][] item = {{10, 2}, {5, 3}, {15, 5}, {7, 7}, {6, 1}, {18, 4}, {3, 1}};
        //6 1 10 2 18 4 15 5 3 1 5 3 7 7
        gfk.getMaxProfit(item,15);
    }

}
