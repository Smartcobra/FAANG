package Sudoko;

import java.util.HashSet;

public class Solution {
    public int isValidSudoku(final String[] A) {
        int N = A.length;
        HashSet<Character>[] row = new HashSet[N];
        HashSet<Character>[] col = new HashSet[N];
        HashSet<Character>[] box = new HashSet[N];


        for (int i = 0; i < N; i++) {
            row[i] = new HashSet<Character>();
            col[i] = new HashSet<Character>();
            box[i] = new HashSet<Character>();

        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                char val = A[r].charAt(c);

                if (val == '.') {
                    continue;
                }

                if (row[r].contains(val)) {
                    return 0;
                }
                row[r].add(val);

                //coll
                if (col[c].contains(val)) {
                    return 0;
                }
                col[c].add(val);

                //box
                int idx = (r / 3) * 3 + (c / 3);
                if (box[idx].contains(val)) {
                    return 0;
                }
                box[idx].add(val);

            }
        }

        return 1;
    }

    public static void main(String[] args) {
        String [] A= { "....5..1.", ".4.3.....", ".....3..1", "8......2.", "..2.7....", ".15......", ".....2...", ".2.9.....", "..4......" };

    }
}
