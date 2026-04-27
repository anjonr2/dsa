Steps to implement
>First, ignore any leading whitespace characters '' until the first non-whitespace character is found
>Check the next character to determine the sign. If it's a '-', the number should be negative. If it's a '+', the number should be positive. If neither is found, assume the number is positive
>Read the digits and convert them into a number. Stop reading once a non-digit character is encountered or the end of the string is reached. Leading zeroes should be ignored during conversion
>Finally return the computed number after applying all the above steps

Input s=" -12345"
Output : -12345
Explanation : 
>Ignore leading whitespaces
>The sign '-' is encountered, indicating the number is negative
>Digits 12345 are read and converted to -12345

Example 2 
Input s = "4193 with words"
Output : 4193
Explanation 
Read the digits 4193 and stop when encountering the first non-digit 


Below how digits are mapped in the ASCII table:
--------------------------------------------------

The character '0' has a decimal value of 48.
The character '1' has a decimal value of 49.
The character '2' has a decimal value of 50....and so on, 
up to '9' which is 57.

If we try to add the character '4' directly to the integer, 
we would actually be adding 52. But to get the actual numeric value, 
we subtract the base value of '0'. Because the digits are sequential in the ASCII table, the math always works out perfectly:

'4' - '0' is equivalent to 52 - 48 = 4 
'7' - '0' is equivalent to 55 - 48 = 7