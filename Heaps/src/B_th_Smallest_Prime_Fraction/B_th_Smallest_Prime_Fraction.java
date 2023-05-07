package B_th_Smallest_Prime_Fraction;


/////https://www.scaler.com/academy/mentee-dashboard/class/41002/homework/problems/6708/?navref=cl_pb_nv_tb


import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Fraction {
    int p;
    int q;
    float f;

    Fraction(int p, int q, float f) {
        this.p = p;
        this.q = q;
        this.f = f;
    }
}

public class B_th_Smallest_Prime_Fraction {
    public static ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = A.size();
        PriorityQueue<Fraction> meanHeap = new PriorityQueue(new Comparator<Fraction>() {
            @Override
            public int compare(Fraction o1, Fraction o2) {
                if (o1.f > o2.f) {
                    return 1;
                } else if (o1.f < o2.f) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });


        for (int i = 0; i < n; i++) {
            int p = A.get(i);
            for (int j = i + 1; j < n; j++) {
                int q = A.get(j);
                if (p < q) {
                    Fraction f = new Fraction(p, q, (float) p / (float) q);
                    meanHeap.add(f);
                }
            }
        }

        Fraction f = null;
        while (B-- > 0) {
            f = meanHeap.poll();
        }
        result.add(f.p);
        result.add(f.q);

        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list1= new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(5);
        System.out.println(solve(list1,3));
    }
}
