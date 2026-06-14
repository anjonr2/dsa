package com.problemsolving.stackandqueue.basic;

import java.util.Stack;

public class BalancedParentheses {

    /* Function to match opening and closing bracket */
    private boolean isMatched(char opening, char closing) {

        return ((opening == '(' && closing == ')') || (opening == '{' && closing == '}')
                || (opening == '[' && closing == ']'));
    }

    /* Function to check if the string is valid */
    public boolean isBalanced(String s) {
        // Initialize a stack to store opening brackets
        Stack<Character> stack = new Stack<>();

        int n = s.length();
        for (int i = 0; i < n; i += 1) {

            // if an opening bracket is found push it to the stack
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            }
            // Else if a closing bracket is found
            else {
                // if stack is empty then there is no option to compare top of the stack with
                // the corresponding closing bracket so return false
                if (stack.isEmpty())
                    return false;

                char ch = stack.peek();
                if (!isMatched(ch, s.charAt(i)))
                    return false;
            }
        }
        return stack.isEmpty();
    }
}

/*
 * Time complexity : o(n), where n is the length of the string . Traversing the
 * string once takes O(n) time
 * 
 * Space complexity : o(n)
 */