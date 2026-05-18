package medium.CountNoOfBinaryStringsWithoutConsecutiveOnes;

public class CountOfBinaryStringsWithoutConsecutiveOnes {
    static int count(int n) {
        if (n == 1)
            return 2;
        if (n == 2)
            return 3;
        return count(n - 1) + count(n - 2);
    }
}
