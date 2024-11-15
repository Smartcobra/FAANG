import java.util.Scanner;

public class Testt {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
     //   String mailId ="";
        System.out.print("Please enter your age : ");
        int age = sc.nextInt();
        System.out.println("You are " + age + " years old");
        if ( age > 21) {
            System.out.println("Eligible");
            if ( age <= 25) {
                System.out.println("Congratulation you have discount");
            }
        } else if (age == 21) {
            System.out.print("Please enter your mail id : ");
           // Thread.sleep(10000);
            sc.nextLine();
            String mailId = sc.nextLine();
            System.out.println("Your mail ID: " + mailId);
        } else {
            System.out.println("Ineligible");
        }
    }
}
