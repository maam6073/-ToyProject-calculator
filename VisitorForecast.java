import java.io.*;

public class VisitorForecast {
    private static int a = 2;
    private static int b = 1;
    private static Double[][] advertisingCostArr = new Double[4][5];

    private static double sum_diff_pow;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void visitorForecast1() throws IOException{
        System.out.println("[인공지능 프로그램 V1]");
        for(int i = 0; i < 4; i++){
            System.out.println("==========================================================");
            System.out.print("[System] 예측에 영향을 주는 원인(광고비)의 값을 알려주세요 (단위 원) : ");
            advertisingCostArr[i][0] = Double.parseDouble(br.readLine());
            advertisingCostArr[i][1] = (a * advertisingCostArr[i][0]) + b;
            System.out.println("[안내] 입력된 광고비는 " + advertisingCostArr[i][0] + "원입니다.");
            System.out.println("[안내] AI의 예측(클릭 수)은 " + advertisingCostArr[i][1] + "회입니다.");

            System.out.print("더 입력하시겠습니까?(y or n) 최대 4개까지 입력됩니다 : ");
            char ch = br.readLine().charAt(0);
            if(ch != 'y' && i < 3) break;
        }
    }

    public static void visitorForecast2() throws IOException{
        System.out.println("[인공지능 프로그램 V2]");
        System.out.println("==========================================================");
        System.out.print("[System] a 값을 입력하여 주세요 : ");
        a = Integer.parseInt(br.readLine());
        System.out.print("[System] b 값을 입력하여 주세요 : ");
        b = Integer.parseInt(br.readLine());
        System.out.println("==========================================================");

        System.out.println();
        System.out.println("[안내] 입력된 광고비는 다음과 같습니다.");
        for(int i = 0; i < advertisingCostArr.length; i++){
            System.out.print(i+1 + " 번째)" + advertisingCostArr[i][0] + "원    ");
        }
        System.out.println();
        System.out.println();
        System.out.println("[안내] AI의 '웹 페이지 방문자' 예측 결과는 다음과 같습니다.");
        for(int i = 0; i < advertisingCostArr.length; i++){
            System.out.println(i+1 + " 번째 예측) " + advertisingCostArr[i][1] + "회 방문");
        }
        System.out.println();
    }



    public static void visitorForecast3() throws IOException{
        System.out.println("[인공지능 프로그램 V3]");
        System.out.println("==========================================================");
        System.out.println("[안내] 인공지능 프로그램에 할당된 데이터");
        for(int i = 0; i < advertisingCostArr.length; i++){
            System.out.print(i+1 + "번 째 데이터) [실제값] 웹 페이지 방문자 수 : ");
            advertisingCostArr[i][2] = Double.parseDouble(br.readLine());
            System.out.println("[인공지능 예측값] 웹 페이지 방문자 수 : " + advertisingCostArr[i][1] + "\n");
        }

        System.out.println();

        for(int i = 0; i < advertisingCostArr.length; i++){
            advertisingCostArr[i][3] = advertisingCostArr[i][2] - advertisingCostArr[i][1];
            advertisingCostArr[i][4] = Math.pow(advertisingCostArr[i][3],2);
            System.out.println("["+i+1 + " 번째 데이터] 실제 값과 예측값의 오차 : " + advertisingCostArr[i][3]);
            System.out.println("[안내] 오차의 제곱 : " + advertisingCostArr[i][4]);
            System.out.println();
            sum_diff_pow += advertisingCostArr[i][4];
        }
        System.out.println("==========================================================");

        System.out.println("[안내] 인공지능 프로그램의 성능(오차의 제곱 합) : " + sum_diff_pow);
    }
}
