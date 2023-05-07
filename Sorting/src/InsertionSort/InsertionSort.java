package InsertionSort;

public class InsertionSort {

   public static void insertionSort(int arr[]){
       int n= arr.length;

       for(int i=1;i<n;i++){
           int currElement =arr[i];
           int j=i-1;
           while(j>=0 && arr[j] > currElement){
               arr[j+1] = arr[j];
               j--;
           }

           arr[j+1] = currElement;
       }

    }

    public static void main(String[] args) {
        int [] arr ={7,2,4,1,5,3};
        insertionSort(arr);
        for (int j : arr) System.out.print(j + " ");
    }
}
