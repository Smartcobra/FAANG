package DiagonalTraversing;

public class DiagonalTraversing {

    public static void diagonalTraverse(int arr[][]){
        for(int g=0;g<arr.length;g++){
            for(int i=0,j=g;j< arr.length;i++,j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 2,3,4,5,6 }, { 1, 2,3,4,5,6 },{ 1, 2,3,4,5,6 },{ 1, 2,3,4,5,6 } ,{ 1, 2,3,4,5,6 }};
        diagonalTraverse(arr);
    }
}
