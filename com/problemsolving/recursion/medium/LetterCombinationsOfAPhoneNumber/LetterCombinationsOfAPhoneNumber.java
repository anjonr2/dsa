package medium.LetterCombinationsOfAPhoneNumber;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {

    private final String[] map;

    /* Constructor to initialze the mapping of digits to characters */
    public LetterCombinationsOfAPhoneNumber() {
        map = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    }

    /* Recursive helper function to generate combinations */
    private void generateLetterCombinations(String digits, List<String> ans, int index, String current) {
        int n = digits.length();

        /* Base case if index reaches end of the digits */
        if (index == n) {

            /* Add the current combination to the answer */
            ans.add(current);
            return;
        }

        /* Get characters corresponding to the current digit */
        String s = map[digits.charAt(index) - '0'];

        for (int i = 0; i < s.length(); i += 1) {
            /*
             * Recursively call function with next index add current character to the string
             */
            generateLetterCombinations(digits, ans, index + 1, current + s.charAt(i));
        }

    }

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0)
            return ans;
        generateLetterCombinations(digits, ans, 0, "");
        return ans;
    }
}
