Given an integer k and a String s, any character in the string can be selected and changed to any uppercase English character. This operation can be performed upto k times. After completing these steps, return the length of the longest substring that contains the same letter

Input s = "BAABAABBBAAA", k = 2
Output = 6

We can change B present at index 0, 3 to A
BAABAA -> AAAAAA

The thought process is very straightforward, first find out each and every substring and while doing so, keep a track of characters and their frequencies 

Approach 
1. First initialize few variables: maxLen as 0 to track the maximum length found and maxFreq as 0 to track the highest frequency of any single character in the window

2.Iterate through the array, which basically be starting point of the substring. For each starting index, initialize a frequency array has to count occurences of characters

3. Update max frequency encountered and store it in maxFre q variable

4. Calculate the changes needed to make. If changes is less than or equal to k, update maxLen with the current valid window