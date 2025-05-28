package com.dsa.strings.reverse.bruteforce;

import java.util.Stack;

public class ReverseString {
    public static String reverse(String str) {
        String reversed = "";
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            stack.push(ch);
        }
        while (!stack.isEmpty()) {
            reversed += stack.peek();
            stack.pop();
        }
        return reversed;
    }
}
