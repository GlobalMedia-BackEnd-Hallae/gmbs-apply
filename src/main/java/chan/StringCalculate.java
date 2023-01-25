package chan;

import java.util.Scanner;

public class StringCalculate {

    // 여러 가지 예외 상황을 처리해주면서 식을 계산하는 함수
    public static Double Calculate(String str)
    {
        double ret = 0;

        // 공백을 기준으로 문자열을 잘라서 배열에 저장해주기
        String[] arr = str.split(" ");

        // 예외 발생 상황 : 빈 문자열이 입력된 경우
        if (arr.length == 0)
            throw new IllegalStateException("예외 상황 발생 : 빈 문자열이 입력되었습니다.");

        for (int i = 0; i < arr.length; i++)
        {
            if (i % 2 == 0)
            {
                try {
                    double num = Double.parseDouble(arr[i]);

                    if (i == 0)
                    {
                        ret = num;
                        continue;
                    }

                    else
                    {
                        if (arr[i - 1].equals("+"))
                            ret += num;

                        else if (arr[i - 1].equals("-"))
                            ret -= num;

                        else if (arr[i - 1].equals("*"))
                            ret *= num;

                        else
                            ret /= num;
                    }
                } catch (NumberFormatException e) {
                    // 예외 발생 상황 : 연산자의 자리에 피연산자가 입력된 경우
                    throw new IllegalStateException("예외 상황 발생 : 연산자의 자리에 피연산자가 입력되었습니다.");
                }
            }

            else
            {
                if (arr[i].equals("+") || arr[i].equals("-") || arr[i].equals("*") || arr[i].equals("/"))
                    continue;

                else
                {
                    // 예외 발생 상황 : 피연산자의 자리에 연산자가 입력된 경우
                    throw new IllegalStateException("예외 상황 발생 : 피연산자의 자리에 연산자가 입력되었습니다.");
                }
            }
        }

        // 예외 발생 상황 : 잘못된 문자열이 입력된 경우 (ex. 8 * 7 +)
        if (arr.length % 2 == 0)
            throw new IllegalStateException("예외 상황 발생 : 잘못된 문자열이 입력되었습니다.");

        return ret;
    }

    public static void main(String[] args)
    {

        // 1. main 함수를 실행하면 입력 안내문을 콘솔에 출력할 수 있다.
        System.out.println("계산하려는 식을 입력하세요 : ");

        // 2. 계산하려는 식을 입력하고 Enter를 누를 수 있다.
        Scanner scanner;
        scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        // 3. 계산 결과를 출력할 수 있다.
        double ans = Calculate(str);
        System.out.print("계산 결과는 ");
        System.out.print(ans);
        System.out.print("입니다.");
    }
}