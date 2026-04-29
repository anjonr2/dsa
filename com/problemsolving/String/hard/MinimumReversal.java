public class MinimumReversal {
    /*
     * Function to find the minimum number of reversals requried to convert the
     * string into a balanced expression
     */
    public int countRev(String s) {
        int n = s.length();

        /*
         * If the string is odd of Length, it is not possbile to balance the parenthesis
         */
        if (n % 2 != 0)
            return -1;

        /* To store the count of opening and closing bracket */
        int open = 0, close = 0;

        for (int i = 0; i < n; i += 1) {
            /* Increment the count if an opening bracket is found */
            if (s.charAt(i) == '(')
                open += 1;

            /* Else(closing bracket is found) */
            else {
                if (open > 0)
                    /* If a opening bracket is there, a pair of balanced parenthesis is formed */
                    open -= 1;
                else
                    /* Otherwise closing bracket remains unbalanced */
                    close += 1;
            }
        }
        int ans = (open / 2) + (open % 2) + (close / 2) + (close % 2);
        return ans;
    }
}
