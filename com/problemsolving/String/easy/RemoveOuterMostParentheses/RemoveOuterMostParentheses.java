package com.problemsolving.String.easy.RemoveOuterMostParentheses;

public class RemoveOuterMostParentheses {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int cnt = 0;

        /* Traverse the string */
        for (char ch : s.toCharArray()) {
            /* If we encounter an opening bracket increase the cnt */
            if (ch == '(') {
                /*
                 * For opening bracket before increasing the count check if cnt is greater than
                 * 0 or not. If cnt>0 then only add to answer and then increase the count
                 */
                if (cnt > 0)
                    result.append(ch);
                cnt += 1;
            } else if (ch == ')') {
                /*
                 * If we encounter a closing bracket decrease the counter. After decreasing
                 * check if cnt>0. If true then add to answer
                 */
                cnt -= 1;
                if (cnt > 0)
                    result.append(ch);
            }
        }
        return result.toString();
    }
}
