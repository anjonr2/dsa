package Divisors.bruteforce;

import java.util.ArrayList;
import java.util.List;

public class Divisor {
    public List<Integer> getDivisor(int N) {
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= N; i += 1) {
            if (N % i == 0)
                divisors.add(i);
        }
        return divisors;
    }
}
