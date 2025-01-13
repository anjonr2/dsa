package com.dsa.stack;

import java.util.Stack;

public class BalancedParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char it : s.toCharArray()) {
            if (it == '(' || it == '{' || it == '[') {
                stack.push(it);
            } else {
                char ch = stack.isEmpty() ? '#' : stack.pop();
                if ((it == ')' && ch != '(') || (it == '}' && ch != '{') || (it == ']' && ch != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
