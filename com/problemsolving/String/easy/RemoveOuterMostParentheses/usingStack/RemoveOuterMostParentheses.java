package com.problemsolving.String.easy.RemoveOuterMostParentheses.usingStack;

import java.util.Stack;

/*
If it's an opening bracket check if stack is empty before pushing the character to stack
If it's a closing bracket first pop from stack then check if stack is empty or not
 */
public class RemoveOuterMostParentheses {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (!stack.isEmpty()) {
                    result.append(ch);
                }
                stack.push(ch);
            } else if (ch == ')') {
                stack.pop();
                if (!stack.isEmpty()) {
                    result.append(ch);
                }
            }
        }
        return result.toString();
    }
}
