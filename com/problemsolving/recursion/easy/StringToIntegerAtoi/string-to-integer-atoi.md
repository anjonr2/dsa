myAtoi(s) converts given string s to 32-bit signed integer

Steps to implement :
1. First , ignore any leading whitespace '' until the first non-whitespace character is found
2. Check the next character to find the sign. If it's a '-', the number should be negative. If it's a '+', the number should be positive. If neither is found, assume the number is positive
3. Read the digits and convert them into a number. Stop reading once non-digit character is found or the end of the string is reached. Leading zeros should be ignored during conversion

Example 1 
    Input s = " -12345"
    Output : -12345

    Input s = "4193 with words"
    output 4193