public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1)
            return "1";

        String prev = countAndSay(n - 1);
        int len = prev.length();

        String ans = "";

        /* to count the frequencies of identicals */
        int count = 1;

        for (int i = 1; i < len; i += 1) {
            /* If identicals are found increment the count */
            if (prev.charAt(i) == prev.charAt(i - 1))
                count += 1;
            else {
                ans += (char) ('0' + count); // Add the frequency
                ans += prev.charAt(i - 1); // Add the digit
                count = 1; // Reset the counter to 1
            }
        }

        /* Adding the frequency for the last digit and the Last digit */
        ans += (char) ('0' + count);
        ans += prev.charAt(len - 1);
        return ans;
    }
}

class TestCountAndSay {
    public static void main(String[] args) {
        int n = 4;
        CountAndSay countAndSay = new CountAndSay();
        String ans = countAndSay.countAndSay(n);
        System.out.println("ans: " + ans);
    }
}
