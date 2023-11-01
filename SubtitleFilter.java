import java.util.*;
import java.io.*;
public class SubtitleFilter {
    final private static String adminId = "admin";
    final private static String adminPw = "0000";
    private static String id;
    private static String pw;
    private static String subTitle;
    private static String[] filterArr = new String[]{"킹","시발","꺼저","미친"};
    private static String[] alternativeWord = new String[]{"열","사랑","용기","희망"};

   public static void subTitleFilter() throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       do {
           System.out.print("[시스템] 유튜브 계정의 아이디를 입력하세요 {Ex - admin} : ");
           id = br.readLine();
           System.out.print("[시스템] 유튜브 계정의 아이디를 입력하세요 {Ex - 0000} : ");
           pw = br.readLine();
           System.out.println();
           if(!(adminId.equals(id) && adminPw.equals(pw)))
               System.out.println("[경고] 유튜브 계정의 아이디 및 비밀번호를 다시 확인해 주세요.");
       }while(!(adminId.equals(id) && adminPw.equals(pw)));

       System.out.println("[안내] 안녕하세요 " + id + "님.");
       System.out.println("[안내] 유튜브 영상의 자막을 생성해 주세요.");
       subTitle = br.readLine();
       System.out.println("===================================");
       System.out.println("[알림] 프로그램의 금칙어 리스트입니다.");
       System.out.println(Arrays.toString(filterArr));
       System.out.println("===================================");
       subTitle = changeSubTitle(subTitle);
       System.out.println("[알림] 자막 순화 프로그램 결과입니다.");
       System.out.println(">>> "+subTitle);
       System.out.println("[안내] 프로그램을 종료합니다.");
   }


   private static String changeSubTitle(String s){
       for(int i = 0; i < filterArr.length; i++){
           if(s.contains(filterArr[i])){
               s = s.replaceAll(filterArr[i],alternativeWord[i]);
           }
       }
       return s;
   }
}
