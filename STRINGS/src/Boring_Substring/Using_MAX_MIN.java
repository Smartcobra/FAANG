package Boring_Substring;

public class Using_MAX_MIN {

    public static int boringString(String A) {
        int oddMax = Integer.MIN_VALUE;
        int oddMin = Integer.MAX_VALUE;
        int evenMax = Integer.MIN_VALUE;
        int evenMin = Integer.MAX_VALUE;
        for (int i = 0; i < A.length(); i++) {
            int val = A.charAt(i) - 'a' + 1;
            if (val % 2 != 0) {
                oddMax = Math.max(oddMax, val);
                oddMin = Math.min(oddMin, val);
            } else {
                evenMax = Math.max(evenMax, val);
                evenMin = Math.min(evenMin, val);
            }
        }
        if (Math.abs(evenMin - oddMax) > 1) {
            return 1;
        }
        if (Math.abs(oddMin - evenMax) > 1) {
            return 1;
        }
        return 0;

    }

    public static void main(String[] args) {
        System.out.println(boringString("ajafafgja"));
    }
}
