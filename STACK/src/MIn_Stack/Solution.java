package MIn_Stack;

import java.util.Stack;

public class Solution {
        Stack<Integer> stack = new Stack<>();
        int min;

        public void push(int val) {
            if (stack.size() == 0) {
                stack.push(val);
                min = val;
            } else if (val >= min) {
                stack.push(val);
            } else {
                stack.push(2 * val - min);
                min = val;
            }

        }

        public void pop() {
            if (stack.size() == 0) {
                System.exit(-1);
            } else {
                if (stack.peek() >= min) {
                    System.out.println(stack.peek());
                } else {
                    int ov = min;
                    min = 2 * min - stack.peek();
                    System.out.println(ov);
                }
            }


        }

        public int top() {
            if (stack.size() == 0) {
                return -1;
            } else {
                if (stack.peek() >= min) {
                    return stack.peek();
                } else {
                    return min;
                }
            }

        }

        public int getMin() {
            return min;

        }


}
