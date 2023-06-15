package service;

import dao.ReturnBooksDAO;
import util.JDBCUtil;
import util.ScanUtil;
import util.View;

public class ReturnBooksService {
   private ReturnBooksService() {}
   private static ReturnBooksService instance = null;
   public static ReturnBooksService getInstance() {
      if(instance == null) instance = new ReturnBooksService();
      return instance;
   }
   ReturnBooksDAO rtBooks = ReturnBooksDAO.getInstance();
   JDBCUtil jdbc = JDBCUtil.getInstance();
   public int returnBookForStudent() {
      
      System.out.println("반납할 책의 책 번호를 입력해주세요");
      System.out.print("책 번호 : ");
      String bkno = ScanUtil.nextLine();
      /* 책이 유효한 번호&&책 상태가 보유중인지 먼저 확인 */
      if(bkno.equals(String.valueOf(jdbc.isDuplicateBK(bkno, "BK_NO")))) {
         // 유효한 책일 경우 대출자가 본인인지 확인
         if(rtBooks.lendingStudentIsU(String.valueOf(JDBCUtil.loginUser.get("STD_NO")), bkno)) {
            // 반납 처리
            int a = rtBooks.returnBooksLend(String.valueOf(JDBCUtil.loginUser.get("STD_NO")), bkno);
            rtBooks.returnBooksBook(String.valueOf(JDBCUtil.loginUser.get("STD_NO")), bkno);
            if(a>=1) {
               // 연체가 아닌 경우
               if(!rtBooks.isOverdue(String.valueOf(JDBCUtil.loginUser.get("STD_NO")), bkno)) {
                  System.out.println("정상반납 되었습니다.");
               } else {
                  System.out.println("연체 되었습니다.");
                  // 대출 이력에 연체일자 업데이트
                  rtBooks.returnOverdueCaseLend(String.valueOf(JDBCUtil.loginUser.get("STD_NO")), bkno);
                  // 학생 정보에 정지일자 업데이트
                  rtBooks.returnOverdueCaseStudent(String.valueOf(JDBCUtil.loginUser.get("STD_NO")), bkno);
               
               } 
            }else {
              System.out.println("아무거나");
               }
         }else {
            System.out.println("대출자가 다른 학생입니다.");
         }
      }else {
         System.out.println("유효하지않은 책 번호입니다.");
      }
      return View.S_MAIN;
   }
   
   public int returnBookForManager() {
      
      String stdno ="";
      
      System.out.println("반납하는 학생의 학번을 입력해주세요");
      stinput : while(true) {
         System.out.print("학번 : ");
         stdno = ScanUtil.nextLine();
         if(stdno.equals(String.valueOf(jdbc.isDuplicateSTD(stdno, "STD_NO")))) {
            System.out.println("학번 : " + stdno);
            System.out.println("이름 : " + rtBooks.studentSelectSTDNAME(stdno, "STD_NAME"));
            
            System.out.println("학생정보가 맞습니까?");
            System.out.println("1.예\t2.아니오");
            String b = ScanUtil.nextLine();
            switch (b) {
            case "1":
               break stinput;
            case "2":
               System.out.println("반납하는 학생의 학번을 입력해주세요");
               continue stinput;
            default:
               System.out.println("다시 입력해주세요.");
               continue stinput;
            }
         }else {
            System.out.println("학번을 잘못 입력하셨습니다.");
         }
      }
      
      System.out.println("반납할 책의 책 번호를 입력해주세요");
      System.out.print("책 번호 : ");
      String bkno = ScanUtil.nextLine();
      /* 책이 유효한 번호&&책 상태가 보유중인지 먼저 확인 */
      if(bkno.equals(String.valueOf(jdbc.isDuplicateBK(bkno, "BK_NO")))) {
         // 유효한 책일 경우 대출자가 본인인지 확인
         if(rtBooks.lendingStudentIsU(stdno, bkno)) {
            // 반납 처리
            int a = rtBooks.returnBooksLend(stdno, bkno);
            rtBooks.returnBooksBook(stdno, bkno);
            if(a>=1) {
               // 연체가 아닌 경우
               if(!rtBooks.isOverdue(stdno, bkno)) {
                  System.out.println("정상반납 되었습니다.");
               } else {
                  System.out.println("연체 되었습니다.");
                  // 대출 이력에 연체일자 업데이트
                  rtBooks.returnOverdueCaseLend(stdno, bkno);
                  // 학생 정보에 정지일자 업데이트
                  rtBooks.returnOverdueCaseStudent(stdno, bkno);
               }
               
            }
         }else {
            System.out.println("대출자가 다른 학생입니다.");
         }
      }else {
         System.out.println("유효하지않은 책 번호입니다.");
      }
      return View.M_STDBOOK;
   }
}