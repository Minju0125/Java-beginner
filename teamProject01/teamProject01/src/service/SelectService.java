package service;

import java.util.List;
import java.util.Map;
import dao.SelectDAO;
import util.JDBCUtil;
import util.ScanUtil;
import util.View;

public class SelectService {
   int resultSize;
   private static SelectService instance = null;
   private SelectService() {}
   public static SelectService getInstance() {
      if(instance == null) instance = new SelectService();
      return instance;
   }
   SelectDAO sld = SelectDAO.getInstance();
   JDBCUtil jdbc = JDBCUtil.getInstance();
   // ���� �˻�
   public int selectBookList() {
      System.out.print("�˻��� å ������ �Է����ּ��� : ");
      String title = ScanUtil.nextLine();
      title = "%"+ title + "%";
      List<Map<String, Object>> list = sld.selectBook(title);
      
      // 10 ���� ����ϱ����� �ڵ�
      int i = 0 ;
      int count = 10;
      if(list.size() == 0) {
    	System.out.println("�˻��� ������ �����ϴ�.");
    	ScanUtil.anyPress();
    	if(JDBCUtil.loginUser.get("STD_CLSCODE").equals("1")) {
            return 31;
         }else if(JDBCUtil.loginUser.get("STD_CLSCODE").equals("2")) {
            return 71;
         }else {
            return 1;
         }
      }
      while(i<list.size()) {
         if(i==(list.size()-1)) {break;}
         for (; i < count; i++) {
            if(i==(list.size()-1)) {break;}
            String no = String.valueOf(list.get(i).get("BK_NO"));
            String shf = String.valueOf(list.get(i).get("BK_SHFCODE"));
            String lds = String.valueOf(list.get(i).get("A"));
            String rsv = String.valueOf(list.get(i).get("B"));
            String bookTitle = String.valueOf(list.get(i).get("BK_TITLE"));
            String wri = String.valueOf(list.get(i).get("BK_WRITER"));
            String pub = String.valueOf(list.get(i).get("BK_PUB"));
            System.out.printf("[���� : %s]\n[���� : %s] [���ǻ� : %s]\n[å��ȣ : %4s] [�����ڵ� : %2s] [���⿩�� : %4s] [���࿩�� : %4s]\n", bookTitle,wri,pub,no,shf,lds,rsv);
            System.out.println("==========================================================");
         }
         inputLoop :   while (true) {
            System.out.println("1. ����������\t|\t2. �ǵ��ư���");
            System.out.println("==========================================================");
            System.out.print("�Է� : ");
            String input = ScanUtil.nextLine();
            jdbc.clearConsole();
            switch (input) {
            case "1":
               count += 10;
               jdbc.clearConsole();
               break inputLoop;
            case "2":
               if(JDBCUtil.loginUser.get("STD_CLSCODE").equals("1")) {
                  return 31;
               }else if(JDBCUtil.loginUser.get("STD_CLSCODE").equals("2")) {
                  return 71;
               }else {
                  return 1;
               }
            default:
               System.out.println("�߸��� �Է��Դϴ�.");
               continue inputLoop;
            }// ����ġ �� ��
         }
      }
      if(JDBCUtil.loginUser.get("STD_CLSCODE").equals("1")) {
         return 31;
      }else if(JDBCUtil.loginUser.get("STD_CLSCODE").equals("2")) {
         return 71;
      }else {
         return 1;
      }
   
   }
   
   
   // ���� ��Ȳ ��ȸ
   public int selectLendStatement() {
      List<Map<String, Object>> list = sld.selectLendInfo();
      int a = list.size();
      switch (a) {
      case 0:
         System.out.println("�������� å�� �����ϴ�.");
         System.out.println();
         System.out.print("�ƹ�Ű�� �Է��Ͽ� �ڷΰ��� >> ");
         while(true) {
            String assa = ScanUtil.nextLine();
            if(assa!=null) break;
         }
         break;
      default:
         System.out.println("���� �Ǽ� : " + a + "��");
         for(int i = 0; i < a ; i++) {
            String no = String.valueOf(list.get(i).get("BK_NO"));
            String bookTitle = String.valueOf(list.get(i).get("BK_TITLE"));
            String wri = String.valueOf(list.get(i).get("BK_WRITER"));
            String pub = String.valueOf(list.get(i).get("BK_PUB"));
            System.out.printf("[���� : %s]\n[���� : %s] [���ǻ� : %s]\n[å��ȣ : %4s]\n", bookTitle, wri, pub, no);
            System.out.println("----------------------------------------------------");
         }
         System.out.print("�ƹ�Ű�� �Է��Ͽ� �ڷΰ��� >> ");
         while(true) {
            String assa = ScanUtil.nextLine();
            if(assa!=null) break;
         }
         break;
      }
      return View.S_MAIN;
   }
   
   // ���� ��Ȳ ��ȸ
   public int selectLendStatement(String stdno) {
      List<Map<String, Object>> list = sld.selectLendInfo();
      int a = list.size();
      switch (a) {
      case 0:
         System.out.println("�������� å�� �����ϴ�.");
         break;
      default:
         System.out.println("���� �Ǽ� : " + a + "��");
         for(int i = 0; i < a ; i++) {
            String no = String.valueOf(list.get(i).get("BK_NO"));
            String bookTitle = String.valueOf(list.get(i).get("BK_TITLE"));
            String wri = String.valueOf(list.get(i).get("BK_WRITER"));
            String pub = String.valueOf(list.get(i).get("BK_PUB"));
            System.out.printf("[���� : %s]\n[���� : %s] [���ǻ� : %s]\n[å��ȣ : %4s]\n", bookTitle, wri, pub, no);
         }
         break;
      }
      return View.S_MAIN;
   }
   
   // ������������ ǥ���� ����Ǽ� ����
   public void viewMypageLendInfo() {
      int bookCount = sld.lendCountInfo();
      System.out.println("����Ǽ� : "+bookCount);
   }
   
   // ������������ ǥ���� ���� ����
   public void viewMypageReserveInfo() {
      Map<String, Object> resInfo = sld.reserveInfo();
      if(resInfo != null) {
         String no = String.valueOf(resInfo.get("BK_NO"));
         String bookTitle = String.valueOf(resInfo.get("BK_TITLE"));
         String canLend = String.valueOf(resInfo.get("A"));
         System.out.printf("[[��������]]\n[å��ȣ : %s] [���� : %s]\n[���� : %s]\n",no,canLend,bookTitle);
      }else {
         System.out.println("[[��������]]\n[����]");
      }
   }
   
   // ��ü��Ȳ ��ȸ(�Ŵ�����)
   public int selectOverStatement() {
      List<Map<String, Object>> list = sld.selectOverList();
      //Į�� �׸�
      // BKNO-å��ȣ | OVERDUE-��ü�� | NAME �л��̸�  | STDNO-�й� | TITLE å����
      System.out.println("[[��ü�� ����]]");
      for(int i = 0 ; i < list.size() ; i++) {
         String bkno = String.valueOf(list.get(i).get("BKNO"));
         String overdue = String.valueOf(list.get(i).get("OVERDUE"));
         String stdname = String.valueOf(list.get(i).get("NAME"));
         String stdno = String.valueOf(list.get(i).get("STDNO"));
         String title = String.valueOf(list.get(i).get("TITLE"));
         System.out.printf("[å��ȣ : %s][��ü�� : %s��][�й� : %s][�л��̸� : %s]\n[å���� : %s]\n", bkno, overdue, stdno, stdname,title);
      }
      return View.M_MAIN;
   }
   
   // ������û ��Ȳ ��ȸ
   public int selectRequestStatement() {
      List<Map<String, Object>> list = sld.selectRequestList();
      //Į�� �׸�
      //REQ_TITLE REQ_WRITER REQ_PUB REQ_PRICE
      
      // 10 ���� ����ϱ����� �ڵ�
      int i = 0 ;
      int count = 10;
      System.out.println("[[������û���]]");
      while(i<list.size()) {
         if(i==(list.size()-1)) {break;}
         for (; i < count; i++) {
            if(i==(list.size()-1)) {break;}
            String bookTitle = String.valueOf(list.get(i).get("REQ_TITLE"));
            String wri = String.valueOf(list.get(i).get("REQ_WRITER"));
            String pub = String.valueOf(list.get(i).get("REQ_PUB"));
            String price = String.valueOf(list.get(i).get("REQ_PRICE"));
            System.out.printf("[���� : %s]\n[���� : %s] [���ǻ� : %s]\n[å ���� : %s��]\n", bookTitle,wri,pub,price);
            System.out.println("==========================================================");
         }
         inputLoop :   while (true) {
            System.out.println("1. ����������\t|\t2. �ǵ��ư���");
            System.out.println("==========================================================");
            System.out.print("�Է� : ");
            String input = ScanUtil.nextLine();
            jdbc.clearConsole();
            switch (input) {
            case "1":
               count += 10;
               jdbc.clearConsole();
               break inputLoop;
            case "2":
               return View.M_MAIN;
            default:
               System.out.println("�߸��� �Է��Դϴ�.");
               continue inputLoop;
            }// ����ġ �� ��
         }
      }
            return View.M_MAIN;
   }
   
   // ������ �ݳ����� �̹ݳ� å ��ȸ
   public int selectReturnToday() {
      List<Map<String, Object>> list = sld.selectRetrunPleaseToday();
      // Į�� �׸�
      // BKNO,TITLE,STDNO,NAME
      System.out.println("[[���� �ݳ��޾ƾ� �� å ���]]");
      for(int i = 0; i<list.size(); i++) {
         String bkno = String.valueOf(list.get(i).get("BKNO"));
         String title = String.valueOf(list.get(i).get("TITLE"));
         String stdno = String.valueOf(list.get(i).get("STDNO"));
         String name = String.valueOf(list.get(i).get("NAME"));
         System.out.printf("[å��ȣ : %s][�й� : %s][�л��̸� : %s��]\n[���� : %s]\n", bkno,stdno,name,title);
         System.out.println("==========================================================");
      }
      return View.M_MAIN;
   }
}