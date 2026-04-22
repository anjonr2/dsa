public class LargestOddNumberInAString {
    /* Function to find largest odd number that is a substring of given string */
    public String largeOddNum(String s) {
        int ind = -1;

        int i;
        for (i = s.length() - 1; i >= 0; i -= 1) {
            if ((s.charAt(i) - '0') % 2 != 0)
                ind = i;
            break;
        }

        /* If no odd number is found return an empty string */
        if (ind == -1)
            return "";

        // skipping any leading zero
        i = 0;
        while (i <= ind && s.charAt(i) == '0')
            i += 1;

        return s.substring(i, ind + 1);
    }
}
