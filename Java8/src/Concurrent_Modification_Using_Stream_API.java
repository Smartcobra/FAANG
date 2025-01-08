import java.util.ArrayList;
import java.util.List;

public class Concurrent_Modification_Using_Stream_API {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            list.add(i);
        }

        Thread modifiedThread = new Thread(()->{
            try{
                Thread.sleep(50);
                list.add(10);
                System.out.println("List Modified");
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        });

        modifiedThread.start();

        try {
            list.stream().forEach(ele->{
                System.out.println("Processing element" + ele);
                try{
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            });
        }catch (Exception e){
            System.out.println("Exception caught: " + e);
        }

        modifiedThread.join(); //It ensures that the main thread does not finish execution before the modifier thread completes its task. This is useful to prevent abrupt program termination if the main thread ends early.
    }
}
