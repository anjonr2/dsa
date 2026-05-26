package medium.GenerateAllParentheses.brute;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    private boolean isValid(String s) {
        int balance = 0;
        for (char c : s.toCharArray()) {
            if (c == '(')
                balance++;
            else
                balance -= 1;
            if (balance < 0)
                return false;
        }
        return balance == 0;
    }

    private void generateAll(String current, int n, List<String> result) {
        if (current.length() == 2 * n) {
            if (isValid(current))
                result.add(current);
        }
        generateAll(current + '(', n, result);
        generateAll(current + ')', n, result);
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateAll("", n, result);
        return result;
    }
}
