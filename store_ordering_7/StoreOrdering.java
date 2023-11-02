package store_ordering_7;

import java.io.IOException;
import java.io.*;

public class StoreOrdering {
    private static int prodCnt = 5;
    private static String[][] productArr = new String[prodCnt][2];
    public static String name;

    private static String prod;
    private static String cnt;

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



    public static void showMenu() throws IOException {

        int menu = 0;

        System.out.println("[Item_Storage_V3]");
        System.out.println("-----------------------");
        System.out.println("[System] 해당 프로그램의 기능입니다.");

        while(true) {
            System.out.println("-----------------------");
            System.out.println("1. 물건 정보(제품명) 등록하기\n" +
                    "2. 물건 정보(제품명) 등록 취소하기\n" +
                    "3. 물건 넣기 (제품 입고)\n" +
                    "4. 물건 빼기 (제품 출고)\n" +
                    "5. 재고 조회\n" +
                    "6. 프로그램 종료");
            System.out.println("-----------------------");

            System.out.print("[System] 원하는 기능의 번호를 입력하세요 : ");
            String check = "";
            if((check = br.readLine()).equals("1") || check.equals("2") || check.equals("3") || check.equals("4")
                    || check.equals("5") || check.equals("6")){
                menu = Integer.parseInt(check);
            }
            else{
                System.out.println("잘못 입력");
                continue;
            }



            switch (menu){
                case 1:
                    System.out.print("제품 등록을 원하는 제품명을 입력하세요 : ");
                    prod = br.readLine();
                    prodInput(prod);
                    break;
                case 2:
                    System.out.print("[System] 제품 등록 취소를 원하는 제품명을 입력하세요 : ");
                    prod = br.readLine();
                    prodRemove(prod);
                    break;
                case 3:
                    System.out.println("[System] 물건의 수량을 추가합니다.(입고)");

                    System.out.println("[System] 현재 등록된 제품 및 수량 ▼");
                    prodSearch();

                    System.out.print("[System] 수량을 추가할 제품명을 입력하세요 : ");
                    prod = br.readLine();

                    System.out.print("[System] 추가할 수량을 입력해주세요 : ");
                    cnt = br.readLine();

                    prodAmountAdd(prod,cnt);

                    System.out.println("[System] 현재 등록된 제품 및 수량 ▼");
                    prodSearch();
                    break;
                case 4:
                    System.out.println("[System] 제품의 출고를 진행합니다.");
                    System.out.println("[System] 현재 등록된 제품 및 수량 ▼");
                    prodSearch();

                    System.out.print("[System] 출고를 진행할 제품명을 입력하세요 : ");
                    prod = br.readLine();
                    System.out.print("[System] 원하는 출고량을 입력하세요 : ");
                    cnt = br.readLine();

                    prodAmountDecrease(prod,cnt);

                    System.out.println("[System] 현재 등록된 제품 및 수량 ▼");
                    prodSearch();
                    break;
                case 5:
                    prodSearch();
                    break;
                case 6:
                    System.out.println("[System] 프로그램을 종료합니다.\n" +
                            "[System] 감사합니다.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("잘못된 입력입니다.");
                    break;
            }
        }


    }


    //제품 등록
    private static void prodInput(String prod){
        for(int i = 0; i < productArr.length; i++){
            if(productArr[i][0] == null){
                productArr[i][0] = prod;
                System.out.println("[System]등록이 완료됐습니다.");
                getProds();
                return;
            }
            else if(i == productArr.length-1){
                System.out.println("제품 등록 수량이 초과하였습니다.");
            }
        }
    }


    //등록된 제품 표시
    private static void getProds(){
        System.out.println("[System] 현재 등록된 제품 목록 ▼");
        for(int i = 0; i < productArr.length; i++){
            System.out.print(productArr[i][0] == null ? "> 등록 가능\n" : "> "+productArr[i][0]+"\n");
        }
    }


    //제품 삭제
    private static void prodRemove(String prod){
        System.out.println("[System] 제품 등록 취소를 원하는 제품명을 입력하세요 : ");
        for(int i = 0; i < productArr.length; i++){
            if(productArr[i][0] != null) {
                if (productArr[i][0].equals(prod)) {
                    productArr[i][0] = null;
                }
            }
        }
        System.out.println("[System] 제품 취소가 완료됐습니다.");
    }


    //제품 개수 등록
    private static void prodAmountAdd(String prod,String cnt){
        for(int i = 0; i < productArr.length; i++){
            if(productArr[i][0] != null) {
                if (productArr[i][0].equals(prod)) {
                    int a = productArr[i][1] != null ? Integer.parseInt(productArr[i][1]) : 0;
                    int b = Integer.parseInt(cnt);
                    productArr[i][1] = a + b + "";
                    System.out.println("[Clear] 정상적으로 제품의 수량 추가가 완료되었습니다.");
                    return;
                }
            }
        }
        System.out.println(prod+" 제품을 찾지 못하였습니다.");
    }


    //제품 개수 삭제
    private static void prodAmountDecrease(String prod,String cnt){
        for(int i = 0; i < productArr.length; i++){
            if(productArr[i][0] != null) {
                if (productArr[i][0].equals(prod)) {
                    int a = productArr[i][1] != null ? Integer.parseInt(productArr[i][1]) : 0;;
                    int b = Integer.parseInt(cnt);
                    int result = (a - b) < 0 ? 0 : a - b;
                    productArr[i][1] = result + "";
                    System.out.println("[Clear] 출고가 완료되었습니다.");
                    return;
                }
            }
        }
        System.out.println(prod+" 제품을 찾지 못하였습니다.");
    }


    //제품 전체 조회
    private static void prodSearch(){
        for(int i = 0; i < productArr.length; i++){
            System.out.print(productArr[i][0] == null ? "> 등록 가능 : " : "> "+productArr[i][0]+" : ");
            System.out.print(productArr[i][1] == null ?  "0개\n" : productArr[i][1]+"개\n");
        }
    }
}
