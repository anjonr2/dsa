package com.problemsolving.stackandqueue.basic.PostfixToInfix;

import java.util.Stack;

public class PostFixToInfix {
    public String postFixToInfix(String postFix) {
        Stack<String> stack = new Stack<>();
        int n = postFix.length();

        // Traverse postfix expression from left to right
        for (int i = 0; i < n; i += 1) {
            char c = postFix.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                stack.push(String.valueOf(c));
            } else {
                String operand1 = stack.pop();
                String operand2 = stack.pop();

                // form the new infix expression with operator in between the operands
                stack.push("(" + operand1 + c + operand2 + ")");
            }
        }
        return stack.pop();
    }
}
