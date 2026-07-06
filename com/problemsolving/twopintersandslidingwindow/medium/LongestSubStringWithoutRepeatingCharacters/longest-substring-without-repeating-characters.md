Given a string S. Find the length of the longest substring without repeating characters

Input s = "abcddabac"
Output : 4
Explanation : The answer is "abcd", with a length of 4

Input S = "aaabbbccc"
Output : 2
Explanation : The answers are "ab", "bc". Both have maximum length of 2

In brute force approach : 
Idea is to first generate all the possible substrings of given array using two for loops. While finding the substrings check if the current character has occurred previously with the help of a hash array. If so, no need to take this substring into consideration as characters are repeating , otherwise calculate the length of current substring


Optimal Approach : 
In Optimal approach we can use two-pointers technique. It uses two indices, l(left) and r(right), which basically indicates a window starting from l and ending at r. 
We can use a HashSet to keep track of characters within the current window (l to r). This allows for efficient checks and ensures no duplicates are present

Approach : 
Initialize l and r pointers to 0. These pointers will define the current window [l,r] that contains characters without repetition, maxLen to 0 to store maximum length of substring found without repeating characters

Use an array hash of size 256(Assuming ASCII characters) to store the last occurrence index of each character in the string. Initialize all elements of hash to -1, indicating that no characters have been encountered yet

While pointer r is less than sizeOfArray -1 , iterate in the array. While iterating check if current character has occurred before using hash array. If so, update the left pointer to index of current character plus 1. This ensures that l moves past the occurrence of the repeated character, effectively removing repeated characters from the window