import java.util.Scanner;

public class ReverseNumber {
    public static int reverseNumber(int number) {

        int reverseNumber = 0;
        boolean isNegavtive = number < 0;
        number = isNegavtive ? -number : number;
        while (number > 0) {
            int lastDigit = number % 10;
            reverseNumber = reverseNumber * 10 + lastDigit;
            number = number / 10;
        }
        return isNegavtive ? -reverseNumber : reverseNumber;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number to be reversed");
        int number = sc.nextInt();
        System.out.println("Number entered " + number);
        int reversedNumber = reverseNumber(number);
        System.out.println("Reversed number is " + reversedNumber);
        sc.close();
    }
}
