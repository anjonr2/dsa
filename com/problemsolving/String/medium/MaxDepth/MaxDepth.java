package com.problemsolving.String.medium.MaxDepth;

public class MaxDepth {
    public int maxDepth(String s) {
        int currentOpen = 0;
        int maxOpen = Integer.MIN_VALUE;
        for (char ch : s.toCharArray()) {
            if (ch == '(')
                currentOpen += 1;
            else if (ch == ')')
                currentOpen -= 1;

            maxOpen = Math.max(currentOpen, maxOpen);
        }
        return maxOpen;
    }
}
