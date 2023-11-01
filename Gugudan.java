import java.util.*;
import java.io.*;
public class Gugudan {
    static int startGugudan = 2;
    static int endGugudan = 9;
    public static void gugudan() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("[안내]희망하는 구구단을 숫자로 입력해 주세요 (2 ~ 9) : ");
        int n = Integer.parseInt(br.readLine());
        br.close();

        System.out.println(n+"단 이 입력되었습니다.");
        if(n >= startGugudan && n <= endGugudan) {
            for (int j = 1; j <= 9; j++) {
                System.out.println(n + " * " + j + " = " + n * j);
            }
        }
        else{
            System.out.println("[경고]구구단은 2단 ~ 9단 까지만 선택할 수 있습니다.");
            System.out.println("프로그램을 종료합니다.");
            System.exit(0);
        }
    }
}
