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
   // 도서 검색
   public int selectBookList() {
      System.out.print("검색할 책 제목을 입력해주세요 : ");
      String title = ScanUtil.nextLine();
      title = "%"+ title + "%";
      List<Map<String, Object>> list = sld.selectBook(title);
      
      // 10 개씩 출력하기위한 코드
      int i = 0 ;
      int count = 10;
      if(list.size() == 0) {
    	System.out.println("검색된 도서가 없습니다.");
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
            System.out.printf("[제목 : %s]\n[저자 : %s] [출판사 : %s]\n[책번호 : %4s] [서가코드 : %2s] [대출여부 : %4s] [예약여부 : %4s]\n", bookTitle,wri,pub,no,shf,lds,rsv);
            System.out.println("==========================================================");
         }
         inputLoop :   while (true) {
            System.out.println("1. 다음페이지\t|\t2. 되돌아가기");
            System.out.println("==========================================================");
            System.out.print("입력 : ");
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
               System.out.println("잘못된 입력입니다.");
               continue inputLoop;
            }// 스위치 문 끝
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
   
   
   // 대출 현황 조회
   public int selectLendStatement() {
      List<Map<String, Object>> list = sld.selectLendInfo();
      int a = list.size();
      switch (a) {
      case 0:
         System.out.println("대출중인 책이 없습니다.");
         System.out.println();
         System.out.print("아무키나 입력하여 뒤로가기 >> ");
         while(true) {
            String assa = ScanUtil.nextLine();
            if(assa!=null) break;
         }
         break;
      default:
         System.out.println("대출 권수 : " + a + "권");
         for(int i = 0; i < a ; i++) {
            String no = String.valueOf(list.get(i).get("BK_NO"));
            String bookTitle = String.valueOf(list.get(i).get("BK_TITLE"));
            String wri = String.valueOf(list.get(i).get("BK_WRITER"));
            String pub = String.valueOf(list.get(i).get("BK_PUB"));
            System.out.printf("[제목 : %s]\n[저자 : %s] [출판사 : %s]\n[책번호 : %4s]\n", bookTitle, wri, pub, no);
            System.out.println("----------------------------------------------------");
         }
         System.out.print("아무키나 입력하여 뒤로가기 >> ");
         while(true) {
            String assa = ScanUtil.nextLine();
            if(assa!=null) break;
         }
         break;
      }
      return View.S_MAIN;
   }
   
   // 대출 현황 조회
   public int selectLendStatement(String stdno) {
      List<Map<String, Object>> list = sld.selectLendInfo();
      int a = list.size();
      switch (a) {
      case 0:
         System.out.println("대출중인 책이 없습니다.");
         break;
      default:
         System.out.println("대출 권수 : " + a + "권");
         for(int i = 0; i < a ; i++) {
            String no = String.valueOf(list.get(i).get("BK_NO"));
            String bookTitle = String.valueOf(list.get(i).get("BK_TITLE"));
            String wri = String.valueOf(list.get(i).get("BK_WRITER"));
            String pub = String.valueOf(list.get(i).get("BK_PUB"));
            System.out.printf("[제목 : %s]\n[저자 : %s] [출판사 : %s]\n[책번호 : %4s]\n", bookTitle, wri, pub, no);
         }
         break;
      }
      return View.S_MAIN;
   }
   
   // 마이페이지에 표시할 대출권수 정보
   public void viewMypageLendInfo() {
      int bookCount = sld.lendCountInfo();
      System.out.println("대출권수 : "+bookCount);
   }
   
   // 마이페이지에 표시할 예약 정보
   public void viewMypageReserveInfo() {
      Map<String, Object> resInfo = sld.reserveInfo();
      if(resInfo != null) {
         String no = String.valueOf(resInfo.get("BK_NO"));
         String bookTitle = String.valueOf(resInfo.get("BK_TITLE"));
         String canLend = String.valueOf(resInfo.get("A"));
         System.out.printf("[[예약정보]]\n[책번호 : %s] [상태 : %s]\n[제목 : %s]\n",no,canLend,bookTitle);
      }else {
         System.out.println("[[예약정보]]\n[없음]");
      }
   }
   
   // 연체현황 조회(매니저용)
   public int selectOverStatement() {
      List<Map<String, Object>> list = sld.selectOverList();
      //칼럼 항목
      // BKNO-책번호 | OVERDUE-연체일 | NAME 학생이름  | STDNO-학번 | TITLE 책제목
      System.out.println("[[연체자 정보]]");
      for(int i = 0 ; i < list.size() ; i++) {
         String bkno = String.valueOf(list.get(i).get("BKNO"));
         String overdue = String.valueOf(list.get(i).get("OVERDUE"));
         String stdname = String.valueOf(list.get(i).get("NAME"));
         String stdno = String.valueOf(list.get(i).get("STDNO"));
         String title = String.valueOf(list.get(i).get("TITLE"));
         System.out.printf("[책번호 : %s][연체일 : %s일][학번 : %s][학생이름 : %s]\n[책제목 : %s]\n", bkno, overdue, stdno, stdname,title);
      }
      return View.M_MAIN;
   }
   
   // 도서신청 현황 조회
   public int selectRequestStatement() {
      List<Map<String, Object>> list = sld.selectRequestList();
      //칼럼 항목
      //REQ_TITLE REQ_WRITER REQ_PUB REQ_PRICE
      
      // 10 개씩 출력하기위한 코드
      int i = 0 ;
      int count = 10;
      System.out.println("[[도서신청목록]]");
      while(i<list.size()) {
         if(i==(list.size()-1)) {break;}
         for (; i < count; i++) {
            if(i==(list.size()-1)) {break;}
            String bookTitle = String.valueOf(list.get(i).get("REQ_TITLE"));
            String wri = String.valueOf(list.get(i).get("REQ_WRITER"));
            String pub = String.valueOf(list.get(i).get("REQ_PUB"));
            String price = String.valueOf(list.get(i).get("REQ_PRICE"));
            System.out.printf("[제목 : %s]\n[저자 : %s] [출판사 : %s]\n[책 가격 : %s원]\n", bookTitle,wri,pub,price);
            System.out.println("==========================================================");
         }
         inputLoop :   while (true) {
            System.out.println("1. 다음페이지\t|\t2. 되돌아가기");
            System.out.println("==========================================================");
            System.out.print("입력 : ");
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
               System.out.println("잘못된 입력입니다.");
               continue inputLoop;
            }// 스위치 문 끝
         }
      }
            return View.M_MAIN;
   }
   
   // 오늘이 반납일인 미반납 책 조회
   public int selectReturnToday() {
      List<Map<String, Object>> list = sld.selectRetrunPleaseToday();
      // 칼럼 항목
      // BKNO,TITLE,STDNO,NAME
      System.out.println("[[금일 반납받아야 할 책 목록]]");
      for(int i = 0; i<list.size(); i++) {
         String bkno = String.valueOf(list.get(i).get("BKNO"));
         String title = String.valueOf(list.get(i).get("TITLE"));
         String stdno = String.valueOf(list.get(i).get("STDNO"));
         String name = String.valueOf(list.get(i).get("NAME"));
         System.out.printf("[책번호 : %s][학번 : %s][학생이름 : %s원]\n[제목 : %s]\n", bkno,stdno,name,title);
         System.out.println("==========================================================");
      }
      return View.M_MAIN;
   }
}