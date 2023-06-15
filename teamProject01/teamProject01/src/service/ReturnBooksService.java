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
      
      System.out.println("�ݳ��� å�� å ��ȣ�� �Է����ּ���");
      System.out.print("å ��ȣ : ");
      String bkno = ScanUtil.nextLine();
      /* å�� ��ȿ�� ��ȣ&&å ���°� ���������� ���� Ȯ�� */
      if(bkno.equals(String.valueOf(jdbc.isDuplicateBK(bkno, "BK_NO")))) {
         // ��ȿ�� å�� ��� �����ڰ� �������� Ȯ��
         if(rtBooks.lendingStudentIsU(String.valueOf(JDBCUtil.loginUser.get("STD_NO")), bkno)) {
            // �ݳ� ó��
            int a = rtBooks.returnBooksLend(String.valueOf(JDBCUtil.loginUser.get("STD_NO")), bkno);
            rtBooks.returnBooksBook(String.valueOf(JDBCUtil.loginUser.get("STD_NO")), bkno);
            if(a>=1) {
               // ��ü�� �ƴ� ���
               if(!rtBooks.isOverdue(String.valueOf(JDBCUtil.loginUser.get("STD_NO")), bkno)) {
                  System.out.println("����ݳ� �Ǿ����ϴ�.");
               } else {
                  System.out.println("��ü �Ǿ����ϴ�.");
                  // ���� �̷¿� ��ü���� ������Ʈ
                  rtBooks.returnOverdueCaseLend(String.valueOf(JDBCUtil.loginUser.get("STD_NO")), bkno);
                  // �л� ������ �������� ������Ʈ
                  rtBooks.returnOverdueCaseStudent(String.valueOf(JDBCUtil.loginUser.get("STD_NO")), bkno);
               
               } 
            }else {
              System.out.println("�ƹ��ų�");
               }
         }else {
            System.out.println("�����ڰ� �ٸ� �л��Դϴ�.");
         }
      }else {
         System.out.println("��ȿ�������� å ��ȣ�Դϴ�.");
      }
      return View.S_MAIN;
   }
   
   public int returnBookForManager() {
      
      String stdno ="";
      
      System.out.println("�ݳ��ϴ� �л��� �й��� �Է����ּ���");
      stinput : while(true) {
         System.out.print("�й� : ");
         stdno = ScanUtil.nextLine();
         if(stdno.equals(String.valueOf(jdbc.isDuplicateSTD(stdno, "STD_NO")))) {
            System.out.println("�й� : " + stdno);
            System.out.println("�̸� : " + rtBooks.studentSelectSTDNAME(stdno, "STD_NAME"));
            
            System.out.println("�л������� �½��ϱ�?");
            System.out.println("1.��\t2.�ƴϿ�");
            String b = ScanUtil.nextLine();
            switch (b) {
            case "1":
               break stinput;
            case "2":
               System.out.println("�ݳ��ϴ� �л��� �й��� �Է����ּ���");
               continue stinput;
            default:
               System.out.println("�ٽ� �Է����ּ���.");
               continue stinput;
            }
         }else {
            System.out.println("�й��� �߸� �Է��ϼ̽��ϴ�.");
         }
      }
      
      System.out.println("�ݳ��� å�� å ��ȣ�� �Է����ּ���");
      System.out.print("å ��ȣ : ");
      String bkno = ScanUtil.nextLine();
      /* å�� ��ȿ�� ��ȣ&&å ���°� ���������� ���� Ȯ�� */
      if(bkno.equals(String.valueOf(jdbc.isDuplicateBK(bkno, "BK_NO")))) {
         // ��ȿ�� å�� ��� �����ڰ� �������� Ȯ��
         if(rtBooks.lendingStudentIsU(stdno, bkno)) {
            // �ݳ� ó��
            int a = rtBooks.returnBooksLend(stdno, bkno);
            rtBooks.returnBooksBook(stdno, bkno);
            if(a>=1) {
               // ��ü�� �ƴ� ���
               if(!rtBooks.isOverdue(stdno, bkno)) {
                  System.out.println("����ݳ� �Ǿ����ϴ�.");
               } else {
                  System.out.println("��ü �Ǿ����ϴ�.");
                  // ���� �̷¿� ��ü���� ������Ʈ
                  rtBooks.returnOverdueCaseLend(stdno, bkno);
                  // �л� ������ �������� ������Ʈ
                  rtBooks.returnOverdueCaseStudent(stdno, bkno);
               }
               
            }
         }else {
            System.out.println("�����ڰ� �ٸ� �л��Դϴ�.");
         }
      }else {
         System.out.println("��ȿ�������� å ��ȣ�Դϴ�.");
      }
      return View.M_STDBOOK;
   }
}