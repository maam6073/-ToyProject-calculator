package electricity_calculator_2;

import java.io.*;

public class ElectricityBillCalculator {
    private static int kWh;
    private static double result;

    //저압 전기 계산
    public static double electricityCal()throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("============================");
        System.out.println("주택용 전기요금(저압) 계산기");
        System.out.println("============================");
        System.out.print("kWh 입력: ");
        kWh = Integer.parseInt(br.readLine());
        int cal = kWh;

        while(cal != 0){
            if(cal > 500){
                result += (cal-500) * 670.6;
                cal -= cal-500;
            }
            else if(cal > 400){
                result += (cal-400) * 417.7;
                cal -= cal-400;
            }
            else if(cal > 300){
                result += (cal-300) * 280.6;
                cal -= cal-300;
            }
            else if(cal > 200){
                result += (cal-200) * 187.9;
                cal -= cal-200;
            }
            else if(cal > 100){
                result += (cal-100) * 125.9;
                cal -= cal-100;
            }
            else{
                result += cal * 60.7;
                cal -= cal;
            }
        }
        System.out.printf("%dkWh의 전기 요금은 %.1f원 입니다.\n",kWh,result);
        return result;
    }
}
