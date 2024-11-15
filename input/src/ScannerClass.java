import java.util.Scanner;

public class ScannerClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();

        int[] arr = new int[length];
        for(int j=0;j<length;j++){
            arr[j]=sc.nextInt();
        }

        System.out.println("The elements of the array are:");
        for (int i = 0; i < length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
