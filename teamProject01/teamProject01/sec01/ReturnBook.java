package teamProject01.sec01;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;

public class ReturnBook {
	Scanner sc = new Scanner(System.in);
	ReturnBook(){}
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	//호출하기 전에 반납할 책번호를 입력받아서 갖고있고, 학번은 입력or 로그인 유저에서 정보를 갖고와서 매개변수로 넣어줍니다.
	public void returnBook(String stdNo, String bkNo){
		Map<String,Object> returnBookRow = null;
		ResultSet rsrs = null;
		int overDue = 0;
		int update = 0;
		LocalDate now = LocalDate.now();
		String sysdate = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		LocalDate result =null;
		String result1 = "";
		String sql = "SELECT * FROM BOOK WHERE BK_LDSNO = ?";
		//연체 테이블에 반납일자를 업데이트하는 쿼리문
		String sql1 = "UPDATE LEND SET LD_RETDATE = TO_DATE('" + sysdate + "', 'yyyy-mm-dd') WHERE LD_NO = (SELECT LD_NO FROM (SELECT LD_NO FROM LEND WHERE STD_NO = '" + stdNo + "' AND BK_NO = '"+ bkNo +"' ORDER BY LD_NO DESC) WHERE ROWNUM = 1)";
		// 업데이트 된 행 한줄 갖고오는 sql문
		String sql2 = "SELECT * FROM (SELECT * FROM LEND WHERE STD_NO = '"+ stdNo +"' AND BK_NO = '" + bkNo + "' ORDER BY LD_NO DESC) WHERE ROWNUM = 1";
		// 연체시 해당 행을 대출 테이블에서 연체일자 구해서 업데이트하는 쿼리문
		String sql3 = "UPDATE LEND SET LD_OVERDUE = (SELECT LD_RETDATE - LD_EPDATE FROM (SELECT * FROM LEND WHERE STD_NO = '" + stdNo + "' AND BK_NO = '" + bkNo + "' ORDER BY LD_NO DESC) WHERE ROWNUM = 1) WHERE LD_NO = (SELECT LD_NO FROM (SELECT LD_NO FROM LEND WHERE STD_NO = '" + stdNo + "' AND BK_NO = '" + bkNo + "' ORDER BY LD_NO DESC) WHERE ROWNUM = 1)";
		// 연체일을 갖고오는 쿼리문
		String sqlOverDue ="SELECT LD_OVERDUE FROM (SELECT * FROM LEND WHERE STD_NO = '" + stdNo + "' AND BK_NO = '" + bkNo + "' ORDER BY LD_NO DESC) WHERE ROWNUM = 1";
		// 반납 시 책 테이블에서 대출자를 null로 만들어주는 쿼리문
		String sql5 = "UPDATE BOOK SET BK_LDSNO = NULL WHERE BK_NO = '" + bkNo + "'";
		// 추천수 하나 증가시키는 쿼리문
		String sql6 = "UPDATE BOOK SET BK_RCNT = (SELECT BK_RCNT FROM BOOK WHERE BK_NO = '" + bkNo + "')+1 WHERE BK_NO = '" + bkNo + "'";
		// 방금 반납한 책이 연체인지 확인하는 쿼리문
		String sql7 = "SELECT * FROM (SELECT * FROM (SELECT * FROM LEND WHERE STD_NO = '" + stdNo + "' AND BK_NO = '" + bkNo + "' ORDER BY LD_NO DESC) WHERE ROWNUM = 1) a where a.ld_retdate > a.ld_epdate";
		if(bkNo.equals((String)(jdbc.isDuplicateBK(bkNo,"BK_NO")))) { //입력한 책번호가 유효한 경우
			if(stdNo.equals((String)(jdbc.selectOneValue(sql, stdNo, "BK_LDSNO")))) { //입력한 책이 입력학 학번으로 빌린게 맞는경우
				try {
					jdbc.daoConn.stmt.executeUpdate(sql5); 
					update = jdbc.daoConn.stmt.executeUpdate(sql1);
					jdbc.daoConn.conn.commit();
				}catch(SQLException e) {
					System.out.println("오류발생");
					e.printStackTrace();
				}
				try {
					rsrs = jdbc.daoConn.stmt.executeQuery(sql7);
					if(rsrs!=null) {
						System.out.println("연체되었습니다. 연체정보를 업데이트합니다.");
						jdbc.daoConn.stmt.executeUpdate(sql3);
						jdbc.daoConn.conn.commit();
						ResultSet rsrsrs = jdbc.daoConn.stmt.executeQuery(sqlOverDue);
						rsrsrs.next();
						overDue = Integer.parseInt((String.valueOf(rsrsrs.getObject("LD_OVERDUE"))));
						result = now.plusDays(overDue);
						result1 = result.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
						// 연체시 해당 학생의 정지일을 sysdate+연체일자로 업데이트하는 쿼리문
						String sql4 = "UPDATE STUDENT SET STD_STDATE = TO_DATE('" + result1 + "', 'YYYY-MM-DD') WHERE STD_NO = '" + stdNo + "'";
						jdbc.daoConn.stmt.executeUpdate(sql4);
						jdbc.daoConn.conn.commit();
					}
				} catch (SQLException e) {
					System.out.println("오류발생");
					e.printStackTrace();
				}catch(Exception e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("대출자가 다른 사람입니다.");
				return;
			}
		}else { // 입력한 책 번호가 유효하지 않은 경우
			System.out.println("책 번호가 유효하지 않습니다.");
			return;
		}
		System.out.println("반납 하신 책을 다른 학생에게도 추천하시겠습니까?");
		System.out.print("1. 추천\t|2. 비추천");
		String reco = sc.nextLine();
		switch (reco) {
		case "1": 
			try {
				jdbc.daoConn.stmt.executeUpdate(sql6);
			} catch (SQLException e) {
				System.out.println("추천 중 오류 발생");
				e.printStackTrace();
			}
			break;
		case "2":
			System.out.println("추천하지 않고 반납을 종료합니다.");	
			return;
		default:
			System.out.println("잘못입력되어 추천을 하지 않습니다.");
			return;
		}
	}
	
	public void returnBookForStudent() {
		System.out.println("반납할 책의 책 번호를 입력해주세요");
		System.out.print("책 번호 : ");
		String bkno = sc.nextLine();
		returnBook((String)(jdbc.loginUser.get("STD_NO")),bkno);
	}
	
	public void returnBookForManager() {
		
		System.out.println("반납하는 학생의 학번을 입력해주세요");
		System.out.print("학번 : ");
		String stdno = sc.nextLine();
		System.out.println("반납할 책의 책 번호를 입력해주세요");
		System.out.print("책 번호 : ");
		String bkno = sc.nextLine();
		returnBook(stdno,bkno);
	}
	
	
	
	
	
	
	
}