import java.util.ArrayList;
import java.util.HashMap;

public class FirstRepeatingElement {
    public static int solve(ArrayList<Integer> A) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int result=0;

        for(Integer i: A){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        for(int i=0;i<A.size();i++){
           // System.out.println(map.get(A.get(i)));
            if(map.get(A.get(i))>1){
                result=A.get(i);
                break;
            }else{
                result=-1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(5);
        list.add(3);
        list.add(4);
        list.add(3);
        list.add(5);
        list.add(6);
        System.out.println(solve(list));
    }
}
