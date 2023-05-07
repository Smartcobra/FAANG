



public class TestSeven extends Thread{
    private static int x;
    public synchronized void doThings(){
        int current=x;
        current++;
        x=current;
    }


    public void run(){
        doThings();
    }

    public static void main(String[] args) {
        TestSeven s = new TestSeven();
        s.start();
    }
}
