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
            /* at 0th index p value is 1 beause p^0 is 1 */
            hashPat = (hashPat + ((pattern.charAt(i) - 'a' + 1) * pRight) % mod) % mod;
            hashText = (hashText + ((text.charAt(i) - 'a' + 1) * pRight) % mod) % mod;

            /*
             * Whenever moving the index multiply with another p . i.e every index we are
             * multiplying a p
             */
            pRight = (pRight * p) % mod;
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i <= m - n; i += 1) {
            /* Comparison of first pattern length text with pattern */
            if (hashPat == hashText) {
                if (text.substring(i, i + n).equals(pattern))
                    ans.add(i);
            }

            /* Updating the hash values */
            if (i < m - n) {
                /*
                 * As part of hash update removes the first character from hash
                 * text.charAt(i) - 'a' + 1 which means if there is character a then it will be
                 * treated as 1 b will be treated as 2 and so on..
                 * 
                 * (text.charAt(i) - 'a' + 1) this basically maps any character in the string to
                 * a number
                 * 
                 */
                hashText = (hashText - ((text.charAt(i) - 'a' + 1) * pLeft) % mod + mod) % mod;

                /* Each iteration of loop checks a window of length n starting at index i */
                hashText = (hashText + ((text.charAt(i + n) - 'a' + 1) * pRight) % mod) % mod;

                hashPat = (hashPat * p) % mod;

                /*
                 * Updating the prime multiples
                 * if we don't use % mod then pRight = pRight * p grows exponentially
                 * multiplication becomes huge and integer overflow happens . So to keep numbers
                 * small at every step we use % mod
                 */
                pLeft = (pLeft * p) % mod;
                pRight = (pRight * p) % mod;
            }

        }
        return ans;
    }
}

/*
 * Time complexity : O(m)
 * 
 * Why a prime number is used to do the mod is because when do modulo by a prime
 * number hash remains same
 * 
 * mod is used because we are multiplying with higher power of p. Like p^4, p^5
 * so there is a chances of overflow. So to avoid that we are doing modulo and
 * taking the mod value
 */

/*
 * The core of the Rabin Karp algorithm is representing a string as a number
 * using a polynomial rolling hash.
 * This allows us to compare a pattern with a sliding window of text
 * (pat.charAt(i)-'a'+1) converts a character (a-z) to a number (1-26). If we do
 * (pat.charAt(i)) instead of substracting 'a' from that character then their
 * ascii value will be a huge number so 'a' is substracted from each character
 * to limit ascii value of [a-z] to [1-26]. So in case if there is large string
 * and some multiplication needs to be done then there will be no overflow
 * 
 * pRight represents current power of p
 * 
 * In this expression two modulo is used to prevent integer overflow
 * hashPat = (hashPat + ((pat.charAt(i) - 'a' + 1) * pRight) % mod) % mod;
 * 
 * The inner module ((pat.charAt(i) - 'a' + 1) * pRight) , before adding it's
 * contribution to total sum or hashPat we apply modulo on ((pat.charAt(i) - 'a'
 * + 1) * pRight)
 * 
 * Intuition behind this is : let's say (pat.charAt(i) - 'a' + 1) is 26 and
 * pRight is a very large power, their product could exceed the maximum limit of
 * an int
 * 
 * So by applying mod immediately after the multiplication we "shrink" the
 * number back down so it fits safely within the integer range before we try to
 * add it to existing hashPat
 * 
 * the outer modulo
 * hashPat = (hashPat + ((pat.charAt(i) - 'a' + 1) * pRight) % mod) % mod;
 * 
 * the final sum remains within range 0 to 100
 * 
 * Because when we perform a modulo operation of a number by 101 (n(mod 101)),
 * the possible range of result is 0 to 100
 * 
 * Range : Result is always a non-negative number less than divisor
 * 
 * Formula : 0 <= (remainder) < 101
 * 
 * Examples :
 * 101(mod 101) = 0
 * 102(mod 101) = 1
 * 103(mod 101) = 2
 * 104(mod 101) = 3
 * 200(mod 101) = 99
 * 50 (mod 101) = 50(if the dividend is smaller than the divisor, the result is
 * the dividend)
 * 
 * This means there are 101 possible remainders , ranging from 0,1,2,...99,100
 * 
 * why pRight = (pRight * p) % mod;?
 * This line updates the power of p for the next character in the loop (e.g
 * changing 7^1 to 7^2)
 * 
 * Problem : Power of prime number grows exponentially. 7^10 is roughly 282
 * million, 7^15 is over 4 trillion, which is far larger than a standard 32-bit
 * Java int can hold
 * 
 * By taking the modulo at every step of multiplication , we ensure that pRight
 * never overflows and our calculation doesn't breaks
 */