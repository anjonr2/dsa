package RabinKarpAlgorithm.optimal;

import java.util.ArrayList;
import java.util.List;

public class StartingIndexOfAllOccurencesOfPattern {
    /* Function to find the starting index of all occurrences of pattern in text */
    public List<Integer> search(String text, String pattern) {
        int n = pattern.length();
        int m = text.length();

        /* Primes for Rabin-Karp algorithm */
        int p = 7, mod = 101;

        /* To store hash values of pattern and substring of text */
        int hashPat = 0, hashText = 0;

        int pRight = 1, pLeft = 1;

        /* Computing the initial hash values */
        for (int i = 0; i < n; i += 1) {
            hashPat += (pattern.charAt(i) * pRight) % mod;
            hashText += (text.charAt(i) * pRight) % mod;

            pRight = (pRight * p) % mod;
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i <= m - n; i += 1) {
            if (hashPat == hashText) {
                if (text.substring(i, i + n).equals(pattern))
                    ans.add(i);
            }

            /* Updating the hash values */
            if (i < m - n) {
                hashText = (hashText - ((text.charAt(i) - 'a' + 1) * pLeft) % mod + mod) % mod;
                hashText = (hashText + ((text.charAt(i + n) - 'a' + 1) * pRight) % mod) % mod;

                hashPat = (hashPat * p) % mod;

                /* Updating the prime multiples */
                pLeft = (pLeft * p) % mod;
                pRight = (pRight * p) % mod;
            }

        }
        return ans;
    }
}

/*
 * Time complexity : O(m)
 */