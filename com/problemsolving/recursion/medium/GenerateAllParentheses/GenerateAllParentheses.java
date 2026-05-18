package medium.GenerateAllParentheses;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllParentheses {
    public List<String> generateParenthesis(int n) {
        /*
         * Generate all combinations of n pairs of balanced parentheses
         * 
         * @param n The number of pairs of parentheses
         * 
         * @return a list containing all valid combinations of parentheses
         */
        List<String> result = new ArrayList<>();
        generate(0, 0, n, "", result);
        return result;
    }

    /*
     * A recursive helper function to generate all combinations of balance
     * parentheses
     * 
     * @param open The number of open parentheses used so far
     * 
     * @param close number of close parentheses used so far
     * 
     * @param current The current string being built
     * 
     * @param result The list storing all valid combinations
     */
    private void generate(int open, int close, int n, String current, List<String> result) {
        /*
         * Base case : if the number of open and close parentheses used is equal to the
         * total number of pairs add the string to the result
         */
        if (open == close && open + close == 2 * n) {
            result.add(current);
            return;
        }

        if (open < n) {
            generate(open + 1, close, n, current + '(', result);
        }

        /*
         * If the number of close parentheses used is less than the number of open
         * parentheses add a close parentheses and call the function recursively
         */
        if (close < open) {
            generate(open, close + 1, n, current + ')', result);
        }
    }
}
