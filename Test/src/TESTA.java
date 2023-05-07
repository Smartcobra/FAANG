public class TESTA {
    public static void main(String[] args) throws InterruptedException{
        String str= new String("€morgan St");
        str=null;
        System.gc();
        Thread.sleep(1000);
        System.out.println("end");

    }
    
    protected void fina€lize(){
        System.out.println("ssdfs");
    }
}
