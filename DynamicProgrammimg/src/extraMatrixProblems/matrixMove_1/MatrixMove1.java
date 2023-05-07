package extraMatrixProblems.matrixMove_1;

public class MatrixMove1 {
    public int getApples(int arr[][]){
        int m=arr.length;
        int n=arr[0].length;

        int s[][]= new int [m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                s[i][j]=arr[i][j];
                if(i>0 && s[i][j] < s[i][j]+s[i-1][j]){
                    s[i][j] += s[i-1][j];
                }
                if(j>0 && s[i][j] < s[i][j]+s[i][j-1] ){
                    s[i][j] += s[i][j-1];
                }
            }

        }
        return s[m][n];
    }
}
