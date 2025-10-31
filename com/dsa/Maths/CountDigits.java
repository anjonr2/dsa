public class CountDigits {
    public int countDigits(int number) {
        int count = 0;
        while (number > 0) {
            count += 1;
            count = count / 10;
        }
        return count;
    }
}
