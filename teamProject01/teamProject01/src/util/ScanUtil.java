package util;

import java.util.Scanner;

public class ScanUtil {
   // 스캐너를 손쉽게 사용할 수 있는 static 메서드를 가지고있음
   static Scanner sc = new Scanner(System.in);
   public static String nextLine() {
      return sc.nextLine();
   }
   public static int nextInt() {
      while(true) {
         try {
            int result = Integer.parseInt(sc.nextLine());
            return result;
         }catch (NumberFormatException e) {
            System.out.println("숫자로 입력해주세요.");
         }
      }
   }
   
   public static void anyPress() {
	   System.out.print("아무키나 입력하여 뒤로가기 >> ");
       while(true) {
          String assa = ScanUtil.nextLine();
          if(assa!=null) break;
       }
       for (int i = 0; i < 80; i++)
			System.out.println();
		
   }
}