package dao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import util.DAOConnection;
import util.JDBCUtil;

public class ReturnBooksDAO {
   Scanner sc = new Scanner(System.in);
   private ReturnBooksDAO(){}
   private static ReturnBooksDAO instance = null;
   public static ReturnBooksDAO getInstance() {
      if(instance==null) instance = new ReturnBooksDAO();
      return instance;
   }
   JDBCUtil jdbc = JDBCUtil.getInstance();
   DAOConnection daoConn = DAOConnection.getInstance();
   
   // �Է¹��� å��ȣ�� �Է¹��� �л������� ������ �ִ��� Ȯ���ϴ� �޼ҵ�
   public boolean lendingStudentIsU(String stdno, String bkno) {
      String sql = "SELECT * FROM BOOK WHERE BK_NO = ?";
      if(stdno.equals(String.valueOf(jdbc.selectOneValue(sql, bkno, "BK_LDSNO")))) {
         return true;
      }else {
         return false;
      }
   }
   
   // å �ݳ��� LEND ���̺��� �����̷¿� �ݳ����� �����ϴ� �޼ҵ�
   public int returnBooksLend(String stdno, String bkno) {
      String sql = "UPDATE LEND SET LD_RETDATE = SYSDATE WHERE LD_RETDATE IS NULL AND STD_NO = ? AND BK_NO = ?";
      List<Object> param = new ArrayList<Object>();
      param.add(stdno);
      param.add(bkno);
      return jdbc.update(sql, param);
      
   }
   
   // å �ݳ��� BOOK ���̺��� �����ڸ� null�� ������ִ� �޼ҵ�
   public int returnBooksBook(String stdno, String bkno) {
      String sql = "UPDATE BOOK SET BK_LDSNO = NULL WHERE BK_LDSNO = ?  AND BK_NO = ?";
      List<Object> param = new ArrayList<Object>();
      param.add(stdno);
      param.add(bkno);
      return jdbc.update(sql, param);
   }
   
   
   // �ݳ��� å�� ��ü���� Ȯ���ϴ� �޼ҵ�
   public boolean isOverdue(String stdno, String bkno) {
      String sql = "SELECT TRUNC(LD_RETDATE - LD_EPDATE) A FROM LEND WHERE STD_NO = ? AND BK_NO = ? AND TO_CHAR(LD_RETDATE,'YYYY-MM-DD')=TO_CHAR(SYSDATE,'YYYY-MM-DD')";
      List<Object> param = new ArrayList<Object>();
      param.add(stdno);
      param.add(bkno);
      
      //��ü�� ��� true
      if(0 < Integer.parseInt(String.valueOf((jdbc.selectOneRow(sql, param)).get("A")))) {
         return true;
      }else { // ��ü�� �ƴѰ�� false
         return false;
      }
   }
   
   
   // ��ü�� ��� �����̷¿� ��ü���� ������Ʈ�ϴ� �޼ҵ�
   public int returnOverdueCaseLend(String stdno, String bkno) {
      List<Object> param = new ArrayList<Object>();
      param.add(stdno);
      param.add(bkno);
      String sqlGetOverdue = "SELECT TRUNC(LD_RETDATE - LD_EPDATE) A FROM LEND WHERE STD_NO = ? AND BK_NO = ? AND TO_CHAR(LD_RETDATE,'YYYY-MM-DD')=TO_CHAR(SYSDATE,'YYYY-MM-DD')";
      int overdue = Integer.parseInt(String.valueOf(jdbc.selectOneValue(sqlGetOverdue, param, "A")));
      String sql = "UPDATE LEND SET LD_OVERDUE = " + overdue + " WHERE STD_NO = ? AND BK_NO = ? AND TO_CHAR(LD_RETDATE,'YYYY-MM-DD')=TO_CHAR(SYSDATE,'YYYY-MM-DD')";
      return jdbc.update(sql, param);
   }
   
   // ��ü�� ��� ��ü�� �л��� �������� �����ϴ� �޼ҵ�
   public int returnOverdueCaseStudent(String stdno, String bkno) {
      List<Object> param = new ArrayList<Object>();
      param.add(stdno);
      param.add(bkno);
      List<Object> paramS = new ArrayList<Object>();
      paramS.add(stdno);
      
      // �л��� �������� ������ ������� ��¥������ ���ڿ�, ������� 0�� ���ڿ��� �������� ������
      String sqlGetStopdate = "SELECT NVL2(STD_STDATE,TO_CHAR(STD_STDATE,'YYYY-MM-DD'),'0') LO FROM STUDENT WHERE STD_NO = ?";
      String stopDate = String.valueOf(jdbc.selectOneValue(sqlGetStopdate, stdno, "LO"));
      
      // ��ü���� �������� �޽���
      String sqlGetOverdue = "SELECT TRUNC(LD_RETDATE - LD_EPDATE) B FROM LEND WHERE STD_NO = ? AND BK_NO = ? AND TO_CHAR(LD_RETDATE,'YYYY-MM-DD')=TO_CHAR(SYSDATE,'YYYY-MM-DD')";
      int overdue = Integer.parseInt(String.valueOf((jdbc.selectOneRow(sqlGetOverdue, param)).get("B")));
      
      // �л� �������� ������ ���
      if(stopDate.equals("0")) {
         String sql = "UPDATE STUDENT SET STD_STDATE = SYSDATE + " + overdue + " WHERE STD_NO = ?";
         return jdbc.update(sql, paramS);
      }else {
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
         LocalDateTime stdate = LocalDateTime.parse(stopDate, formatter);
         stdate = stdate.plusDays(overdue);
         String newStopDate = stdate.format(formatter);
         String sql = "UPDATE STUDENT SET STD_STDATE = TO_DATE('" + newStopDate + "', 'YYYY-MM-DD') WHERE STD_NO = ?";
         return jdbc.update(sql, paramS);
      }
   }

   public String studentSelectSTDNAME(String stdno, String colmName) {
      String sql = "SELECT * FROM STUDENT WHERE STD_NO = ?";
      return String.valueOf(jdbc.selectOneValue(sql,stdno,colmName));
   }
   
}