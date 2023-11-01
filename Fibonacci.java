import java.util.*;
import java.io.*;
public class Fibonacci {
    private static int num;
    private static int[] arr;

    public static void fibonacci() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("[안내]피보나치 수열 프로그램 시작.");
        System.out.print("원하는 수열의 개수를 입력해 주세요 : ");
        num = Integer.parseInt(br.readLine());
        arr = new int[num];
        System.out.println("[피보나치 수열 출력]");
        fiboCalculate(num);
        System.out.println("[안내]프로그램을 종료합니다.");
    }



    public static void fiboCalculate(int num){
        arr[0] = 1;
        arr[1] = 1;
        for(int i = 0; i < arr.length-2; i++){
            arr[i + 2] = arr[i] + arr[i+1];
        }

        for(int i : arr){
            System.out.println(i);
        }
    }

//    public static int fiboCalculate(int num){
//        if(num <= 2){
//            return 1;
//        }
//        int result = fiboCalculate(num-1 ) + fiboCalculate(num-2);
//        System.out.println(result);
//        return result;
//    }
}
