package calculator_1;

import java.io.*;
public class Calculator {
    private static double num1;
    private static String sign;
    private static double num2;
    private static double result;

    public static TwoValues cal() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("계산기 프로그램입니다.");

        System.out.println("첫번째 숫자를 입력해주세요");
        num1 = Double.parseDouble(br.readLine());

        System.out.println("부호를 입력해주세요 ( +, -, *, / 만 입력가능 ) ");
        sign = br.readLine();

        System.out.println("두번째 숫자를 입력해주세요");
        num2 = Double.parseDouble(br.readLine());


        switch (sign) {
            case "+":
                result += num1 + num2;
                break;
            case "-":
                result += num1 - num2;
                break;
            case "*":
                result += num1 * num2;
                break;
            case "/":
                result += num1 / num2;
                break;
            default:
                System.out.print("잘못된 부호입니다 프로그램을 종료합니다.");
                System.exit(0);
        }

        show();

        String check = "";
        System.out.print("계속 계산하시겠습니까? (y or n)");
        check = br.readLine();

        while (check.equals("y")) {
            System.out.println("부호를 입력해주세요.");
            sign = br.readLine();

            if(!(sign.equals("+") || sign.equals("-") || sign.equals("*") || sign.equals("/"))){
                System.out.print("부호가 올바르지않습니다 다시 입력해주세요.");
                continue;
            }

            System.out.println("계산할 수를 입력해주세요.");
            num2 = Double.parseDouble(br.readLine());

            switch (sign) {
                case "+":
                    result += num2;
                    break;
                case "-":
                    result -= num2;
                    break;
                case "*":
                    result *= num2;
                    break;
                case "/":
                    result /= num2;
                    break;
                default:
                    System.out.print("잘못된 부호입니다 프로그램을 종료합니다.");
                    System.exit(0);
            }

            show();

            System.out.println("계속 계산하시겠습니까? (y or n))");
            check = br.readLine();
        }
        return show();
    }

    public static TwoValues show(){
        if (result % 1 == 0.0) {
            return new TwoValues((int) result);
        }
        else {
            return new TwoValues(result);
        }
    }
}
