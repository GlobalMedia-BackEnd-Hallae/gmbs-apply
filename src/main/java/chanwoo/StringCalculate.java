package chanwoo;

import chanwoo.calculate.StringCalculator;
import java.util.Scanner;

public class StringCalculate {
    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator();
        Scanner scanner = new Scanner(System.in);
        stringCalculator.run(scanner.nextLine());
    }
}
