package com.problemsolving.String.easy.ReverseEveryWordInAString.optimal;

public class ReverseWordsInAString {
    private void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start += 1;
            end += 1;
        }
    }

    public String reverseWords(String s) {
        int n = s.length();

        StringBuilder sb = new StringBuilder();
        reverseString(sb, 0, n - 1);

        int i = 0, j = 0, start = 0, end = 0;

        while (j < n) {
            /* skip spaces */
            while (j < n && j == ' ') {
                j += 1;
            }

            if (j == n)
                break;

            start = i;

            // copy the characters forward
            while (j < n && s.charAt(j) != ' ') {
                if (i < sb.length()) {
                    sb.setCharAt(i += 1, sb.charAt(j += 1));
                } else {
                    sb.append(sb.charAt(j += 1));
                    i += 1;
                }
            }

            end = i - 1;

            // reverse the current word using start and end
            reverseString(sb, start, end);

            if (j < n) {
                if (i < sb.length())
                    sb.setCharAt(i += 1, ' ');
                else
                    sb.append(' ');
                i += 1;
            }

            // remove trailing spaces
            if (i > 0 && sb.charAt(i) == ' ')
                i -= 1;

            return sb.substring(0, i);
        }
    }
}
