package hard;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {
    private void generatePalindromePartitions(List<List<String>> result, List<String> path, String s, int index) {
        int n = s.length();

        /* Base case : If index reaches end of the string */
        if (index == n) {
            // Add the current partition to the list
            result.add(path);
            return;
        }

        for (int i = index; i < n; i += 1) {
            /* Check if the substring s[index .. i] is a palindrome */
            if (isPalindrome(s, index, i)) {
                /* If true add to the current path */
                path.add(s.substring(index, i + 1));

                /* recur for the remaining substring */
                generatePalindromePartitions(result, path, s, index + 1);

                /* back track remove the last added substring */
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }

    public List<List<String>> partition(String s) {
        /* Resultant list to store all the list of partitions */
        List<List<String>> result = new ArrayList<>();

        List<String> path = new ArrayList<>();

        generatePalindromePartitions(result, path, s, 0);

        return result;
    }
}

/*
 * Time complexity :O(n * 2^n) , where n is the length of the string given. This
 * is because we generate all possible partitions(exponential) and each
 * palindrome check can take up to O(n)
 * 
 * Space complexity : O(n) because the auxiliary space used (recursion stack +
 * path) is O(n)
 */