import java.util.Stack;

public class ReverseStack {
    private static void insertAtBottom(Stack<Integer> stack, int topVal) {
        if (stack.isEmpty()) {
            stack.push(topVal);
            return;
        }

        /* Pop the top element */
        int top = stack.pop();

        insertAtBottom(stack, topVal);

        /* Push the popped element back */
        stack.push(top);
    }

    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty())
            return;

        /* Pop the top element */
        int top = stack.pop();

        reverse(stack);

        /* Insert the top element at the bottom */
        insertAtBottom(stack, top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(4);
        stack.push(1);
        stack.push(3);
        stack.push(2);

        reverse(stack);

        System.out.println("Reversed stack: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }
}
