package medium.GenerateBinaryStringWithoutConsecutiveOnes;

import java.util.ArrayList;
import java.util.List;

public class GenerateBinaryStringWithoutConsecutiveOnes {
    static void generate(int n, String curr, List<String> result) {
        /* Base case : if length is 'n' add to the result */
        if (curr.length() == n) {
            result.add(curr);
            return;
        }

        generate(n, curr + "0", result);

        /* Add 1 only if previous character is not 1 */
        if (curr.isEmpty() || curr.charAt(curr.length() - 1) != '1') {
            generate(n, curr + "1", result);
        }
    }

    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        generate(3, "", result);
        for (String s : result) {
            System.out.print(s + " ");
        }

        System.out.println();
    }
}
