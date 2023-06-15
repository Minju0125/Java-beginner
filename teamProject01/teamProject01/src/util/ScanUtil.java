package util;

import java.util.Scanner;

public class ScanUtil {
   // ��ĳ�ʸ� �ս��� ����� �� �ִ� static �޼��带 ����������
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
            System.out.println("���ڷ� �Է����ּ���.");
         }
      }
   }
   
   public static void anyPress() {
	   System.out.print("�ƹ�Ű�� �Է��Ͽ� �ڷΰ��� >> ");
       while(true) {
          String assa = ScanUtil.nextLine();
          if(assa!=null) break;
       }
       for (int i = 0; i < 80; i++)
			System.out.println();
		
   }
}