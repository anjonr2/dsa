package easy.PowOfx.recursive;

public class PowerOfx {
    private double calculatePower(double el, long pow) {
        /* Base case : anything raised to power 0 is 1 */
        if (pow == 0)
            return 1;

        /* Base case : anything raised to power 1 is that element itself */
        if (pow == 1)
            return el;

        /* If n is even */
        if (pow % 2 == 0) {
            return calculatePower(el * el, pow / 2);
        }

        /* if n is odd */
        return el * calculatePower(el, pow - 1);
    }

    public double power(double el, int pow) {
        /* convert n to long to avoid integer overflow */
        long num = pow;

        if (num < 0) {
            return (1.0 / calculatePower(el, -num));
        }

        return calculatePower(el, num);
    }
}

/*
 * Time complexity : O(logn) due to halving of n in the even case and linear
 * reduction and then halving in odd case
 */