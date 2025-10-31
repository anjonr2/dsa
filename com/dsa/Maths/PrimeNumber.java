public class PrimeNumber {
    public boolean isPrime(int number) {
        int cnt = 0;
        for (int i = 1; i * i <= number; i += 1) {
            if (number % i == 0)
                cnt += 1;
            if (i != number / i)
                cnt += 1;
        }
        if (cnt == 2)
            return true;
        else
            return false;
    }
}
