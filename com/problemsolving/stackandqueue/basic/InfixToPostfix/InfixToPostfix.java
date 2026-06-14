package com.problemsolving.stackandqueue.basic.InfixToPostfix;

import java.util.Stack;

public class InfixToPostfix {
    // Function to return precedence of operators
    private static int precedence(char c) {
        if (c == '^') // Exponent operator has highest precedence
            return 3;
        else if (c == '*' || c == '/') // Multiplication and division have higher precedence than addition
            return 2;
        else if (c == '+' || c == '-')
            return 1;
        else
            return -1;
    }

    /* Function to convert infix expression to postfix expression */
    public static String infixtoPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();

        // stack to hold operators and parentheses
        Stack<Character> stack = new Stack<>();
        int n = infix.length();

        for (int i = 0; i < n; i += 1) {
            char c = infix.charAt(i);

            // If the scanned character is an operand (i.e alphabets or numericals add it to
            // the resultant string)
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            }

            /* If scanned character is an opening bracket */
            else if (c == '(') {
                stack.push(c);
            }

            /*
             * If the scanned character is a closing bracket then pop from the stack until
             * stack is not empty and an opening bracket is encountered
             */
            else if (c == ')') {
                while (stack.peek() != '(') {
                    postfix.append(stack.pop());
                }

                // pop the '(' opening bracket from the stack
                stack.pop();
            }

            else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }

        // Pop all the remaining element from the stack
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }
        return postfix.toString();
    }
}

/*
 * Time complexity : O(N) where N is the length of the infix expression.
 * Space complexity : O(N) for the stack used
 */