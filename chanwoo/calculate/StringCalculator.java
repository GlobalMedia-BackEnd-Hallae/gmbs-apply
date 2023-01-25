package chanwoo.calculate;

public class StringCalculator {

    public void run(String input) {
        String[] strings = separate(input);
        double result = toDouble(strings[0]);
        for (int i = 0; i < strings.length - 2; i += 2) {
            result = calculate(strings[i + 1], result, toDouble(strings[i + 2]));
        }
        System.out.println(result);
    }

    private double calculate(String operator, double a, double b) {
        return switch (operator) {
            case "+" -> Calculator.add(a, b);
            case "-" -> Calculator.subtract(a, b);
            case "*" -> Calculator.multiply(a, b);
            case "/" -> Calculator.divide(a, b);
            default -> throw new IllegalArgumentException("다른 연산자 제공 안합니다");
        };
    }

    private double toDouble(String s) {
        checkOperator(s);
        return Double.parseDouble(s);
    }

    private void checkOperator(String s) {
        switch (s) {
            case "+", "-", "*", "/" -> throw new IllegalArgumentException("숫자가 입력되어야 합니다");
        }
    }

    private String[] separate(String s) {
        checkBlank(s);
        return s.split(" ");
    }

    private void checkBlank(String s) {
        if (s.equals(" ")) {
            throw new IllegalArgumentException("공백이 입력되었습니다");
        }
    }
}
