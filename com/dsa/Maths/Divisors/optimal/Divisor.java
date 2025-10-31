package Divisors.optimal;

import java.util.ArrayList;
import java.util.List;

public class Divisor {
    public List<Integer> getDivisor(int N) {
        List<Integer> divisor = new ArrayList<>();

        // loop from 1 to square root of N
        for (int i = 1; i * i <= N; i += 1) {
            if (N % i == 0) {
                divisor.add(i);
                if (i != N / i) {
                    divisor.add(N / i);
                }
            }
        }
        return divisor;
    }
}
