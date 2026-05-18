package easy.SortAStack;

import java.util.Stack;

public class SortAStack {
    /* Function to insert element in sorted order */
    public void insert(Stack<Integer> stack, int temp) {
        if (stack.isEmpty() || stack.peek() <= temp) {
            stack.push(temp);
            return;
        }

        int val = stack.pop();
        insert(stack, temp);
        stack.push(val);
    }

    public void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int top = stack.pop();
            sortStack(stack);
            insert(stack, top);
        }
    }
}
