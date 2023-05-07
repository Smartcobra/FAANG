package TWO_D_Matrix;

public class PrintDiagonals {

    public static void printDiagonals(int [][] arr){
       int n=arr.length;
       int m=arr[0].length;
       int i=0;
       int j=0;
        int k=m-1;
       while(i<n){
           System.out.print(arr[i][i] +" ");
           i++;
       }
        System.out.println();

        while(j<n && k>=0){
            System.out.print(arr[j][k] +" ");
            j++;
            k--;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4, 5},
                      {6, 7, 8, 9, 10},
                   {11, 12, 13, 14, 15},
                    {16, 17, 18, 19, 20},
                    {21, 22, 23, 24, 25}};

        printDiagonals(arr);
    }
}
