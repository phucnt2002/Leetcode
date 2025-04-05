package leetcode.stack;

import java.nio.file.LinkOption;
import java.util.Stack;

public class MinStack {
    private Stack<Long> stack;
    private long min;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            min =  val;
            stack.push(0L);
        } else {
            stack.push(val - min);
            if(val<min)
                min=val;
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;
        long top = stack.pop();
        if (top < 0) {
            min = min - top;
        }
    }

    public int top() {
        long top = stack.peek();
        if (top > 0) {
            return (int)(min + top);
        } else {
            return (int)min;
        }
    }

    public int getMin() {
        return (int)min;
    }
}
