package MIn_Stack;

import java.util.Stack;

public class Solution2 {
    Stack<Integer> stack = new Stack<>();
    int min = -1;


    public void push(int val) {
        if (stack.size() == 0) {
            stack.push(val);
            min = val;
        } else if (val > min) {
            stack.push(val);
        } else {
            stack.push(2 * val - min);
            min = val;
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            int top = stack.peek();
            if (top < min) min = 2 * min - top;
            stack.pop();
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
        if (stack.isEmpty()) return -1;
        return min;

    }

}
