import java.util.Stack;

public class RemoveKDigits {
    /*
     * Function to find smallest possible number after removing k digits
     */
    public String removeKDigits(String nums, int k) {
        Stack<Character> st = new Stack<>();

        int n = nums.length();

        /* Traverse on the given string */
        for (int i = 0; i < n; i += 1) {

            // current digit
            char digit = nums.charAt(i);

            /*
             * If the current digit is smaller than the last digit which is present in the
             * top of the stack, then remove top element of the stack
             */
            while (!st.isEmpty() && k > 0 && st.peek() > digit) {
                st.pop(); // pop the last digit
                k -= 1; // decrement k by 1
            }

            // push the current digit
            st.push(digit);
        }

        /*
         * When the given string is sorted
         * for example nums = "12345"
         * then top of the stack will always be smaller than current digit
         * 
         * if top the stack is 1 and current digit is 2 then
         * this condition will never become true
         * st.peek() > digit
         * 
         * so code will never go inside if while block and will decrement k
         * so for sorted string like "12345" k will remain same as it was in the given
         * input
         * 
         * in such case we need to check if k is still greater than zero then pop top k
         * elements from the stack
         */

        while (!st.isEmpty() && k > 0) {
            st.pop();
            k -= 1;
        }

        if (st.isEmpty())
            return "0";

        // to store the result
        StringBuilder result = new StringBuilder();

        // adding digits to the result
        while (!st.isEmpty()) {
            result.append(st.pop());
        }

        while (result.length() > 0 && result.charAt(result.length() - 1) == '0') {
            result.deleteCharAt(result.length() - 1);
        }

        /* reverse the stack since stack elements in reverse orders */
        result.reverse();

        if (result.length() == 0)
            return "0";

        return result.toString();
    }
}
