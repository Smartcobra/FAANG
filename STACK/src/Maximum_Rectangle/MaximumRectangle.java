//package Maximum_Rectangle;
//
//import java.util.ArrayList;
//
//public class MaximumRectangle {
//    public static ArrayList<ArrayList<Integer>> findPrefixMatrix(ArrayList<ArrayList<Integer>> A) {
//        int R=A.size();
//        int C=A.get(0).size();
//        System.out.println(R+"--"+C);
//        ArrayList<ArrayList<Integer>> prefix=new ArrayList<>();
//
//
////        for (int i = 0; i < C; i++) {
////            col_prefixArr[0][i] = arr[0][i];
////            for (int j = 1; j < R; j++) {
////                col_prefixArr[j][i] = arr[j][i] + col_prefixArr[j - 1][i];
////            }
////        }
//
//        for(int i=0;i<C;i++){
//          //  ArrayList<Integer> tmp=new ArrayList<>();
//            int val=A.get(0).get(i);
//            prefix.add(0);
//            for(int j=1;j<C;j++){
//                if(A.get(i).get(j)!=0){
//                    int val=A.get(i).get(j-1)+A.get(i).get(j);
//                    tmp.add(val);
//                }
//            }
//            prefix.add(tmp);
//        }
//
//        return prefix;
//    }
//
//    public static void main(String[] args) {
//        ArrayList<Integer> r1= new ArrayList<>();
//        r1.add(1);
//        r1.add(1);
//        r1.add(0);
//        r1.add(1);
//        r1.add(0);
//        r1.add(1);
//
//        ArrayList<Integer> r2= new ArrayList<>();
//        r2.add(0);
//        r2.add(1);
//        r2.add(1);
//        r2.add(1);
//        r2.add(1);
//        r2.add(1);
//
//        ArrayList<Integer> r3= new ArrayList<>();
//        r3.add(1);
//        r3.add(1);
//        r3.add(1);
//        r3.add(1);
//        r3.add(1);
//        r3.add(0);
//
//        ArrayList<Integer> r4= new ArrayList<>();
//        r4.add(1);
//        r4.add(0);
//        r4.add(1);
//        r4.add(0);
//        r4.add(0);
//        r4.add(1);
//
//        ArrayList<Integer> r5= new ArrayList<>();
//        r5.add(1);
//        r5.add(1);
//        r5.add(0);
//        r5.add(0);
//        r5.add(1);
//        r5.add(1);
//
//        ArrayList<ArrayList<Integer>> matrix= new ArrayList<>();
//        matrix.add(r1);
//        matrix.add(r2);
//        matrix.add(r3);
//        matrix.add(r4);
//        matrix.add(r5);
//
//        for (ArrayList<Integer> r:matrix){
//            for (Integer el:r){
//                System.out.print(el+" ");
//            }
//            System.out.println();
//        }
//        System.out.println("---------");
//        ArrayList<ArrayList<Integer>> prefixMatrix = findPrefixMatrix(matrix);
//        for (ArrayList<Integer> r:prefixMatrix){
//            for (Integer el:r){
//                System.out.print(el+" ");
//            }
//            System.out.println();
//        }
//
//    }
//}
