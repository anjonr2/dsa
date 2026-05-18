package easy.PowOfx;

public class PowerOfx {
    public double power(double el, int pow) {
        /*
         * Base case : any number to the power of 0 is 1
         * 1 raised to any number of pow is 1
         */
        if (pow == 0 || el == 1.0)
            return 1;

        long temp = pow;

        if (pow < 0) {
            el = 1 / el;
            temp = -1L * temp;
        }

        double ans = 1;
        for (int i = 0; i < temp; i += 1) {
            /* Multiply that number n times */
            ans = ans * el;
        }
        return ans;
    }
}
