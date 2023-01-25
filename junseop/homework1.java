package junseop;

import java.util.Scanner;

public class homework1 {
    public static double add(double a, double b){
        return a + b;
    }

    public static double sub(double a, double b){
        return a - b;
    }

    public static double mul(double a, double b){
        return a * b;
    }

    public static double div(double a, double b){
        try{
            return a / b;
        } catch (Exception e){
            System.out.println("0으로 나눌 수 없습니다");
        }
        return 0;
    }
    public static double calculate(double num1, char oper, double num2){

        if(oper == '+')
            return add(num1, num2);

        if(oper== '-')
            return sub(num1, num2);

        if(oper == '*')
            return mul(num1,num2);

        if(oper == '/')
            return div(num1, num2);

        else System.out.println("입력된 값을 확인하세요");
        throw new IllegalArgumentException();
    }
    public static String[] seperate(String str){
        return str.split(" ");
    }

    public static double todouble(String str){
        return Double.parseDouble(str);
    }

    public static double calculateString(String[] str){
        double result = todouble(str[0]);
        for(int i = 0; i < str.length - 2; i += 2){
            result = calculate(result, str[i + 1].charAt(0), todouble(str[i + 2]));
        }
        return result;
    }
    public static String input() {
        String str = new Scanner(System.in).nextLine();
        if(str == null) throw new IllegalArgumentException();
        return str;
    }

    public static void main(String[] args) {
        System.out.print("계산하려는 식을 입력하세요 : ");

        try {
            String expression = input();
            String[] seperateExpression = seperate(expression);
            double num = calculateString(seperateExpression);
            System.out.println("계산 결과는 " + num + " 입니다");
        } catch (IllegalArgumentException e) {
            System.out.println("입력된 값을 확인해주세요. ");
        }

    }

}
