import java.util.ArrayList;
import java.util.List;

public class ExtractDigit {
    public List<Integer> extractDigit(int number) {
        List<Integer> digits = new ArrayList<>();
        while (number > 0) {
            // number%10 gives the last digit of a number
            // ex if number=1234 then 1234%10=4
            digits.add(number % 10);

            // number/10 removes the last digit from a number
            // ex if number=1234 then 1234/10=123
            number = number / 10;
        }
        return digits;
    }

}
