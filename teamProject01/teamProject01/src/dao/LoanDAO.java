package dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import util.JDBCUtil;



public class LoanDAO { // DB�κ��� �����͸� �����ͼ� service�� �Ѱ���
	
	private static LoanDAO instance = null;
	private LoanDAO() {
		
	}
	public static LoanDAO getInstance() {
		if(instance == null)
			instance = new LoanDAO();
		return instance;
	}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();
	Scanner sc = new Scanner(System.in);

	// �ݳ��������� ���� å�� �ѱ��̶� �ִ��� �Ǵ��ϴ� �޼ҵ�
	public List<Map<String, Object>> judgeOverdueCount(Object id) {

		String sql = " SELECT TRUNC(TO_DATE(LD_EPDATE, 'yy-MM-dd') - TRUNC(SYSDATE)) AS COUNT FROM LEND WHERE STD_NO =? AND LD_RETDATE IS NULL";
		List<Object> param = new ArrayList<>();
		param.add(id);

		return jdbc.selectList(sql, param);
	}

	// �ִ�Ǽ��� 3�� �̸����� �Ǵ��ϴ� �޼ҵ�
	public Object judgeMax(Object id) {
		String sql = "SELECT COUNT(*) FROM BOOK WHERE BK_LDSNO = ?";
		String columnName = "COUNT(*)";
		Object param = id;

		return jdbc.selectOneValue(sql, param, columnName);
	}

	// å�� �Է��ϸ� �� å�� ���� Ʃ�� �� �� ������
	public Map<String, Object> judgeBook(Object bookNo) {

		String sql = "select * from book where BK_NO = ?";
		List<Object> param = new ArrayList<>();
		param.add(bookNo);

		return jdbc.selectOneRow(sql, param);

	}

	// sql�� �̿��ؼ� �������̺�, �л����̺� ���� ������Ʈ�ϴ� �޼ҵ� //////, ���� �ϴ� �޼ҵ�
	public int loanLendTable(String inputBookNo, String id) { // �Ϸ�Ǹ� 1 ��ȯ, �����ϸ� 2 ��ȯ

		LocalDate now = LocalDate.now();
		LocalDate nowFrom7DayLater = now.plusDays(7);

		String sql = "INSERT INTO LEND(BK_NO, STD_NO, LD_NO, LD_DATE, LD_EPDATE, LD_RETDATE, LD_OVERDUE) VALUES(?, ?, LENDNO_SEQ.NEXTVAL, sysdate, '"
				+ nowFrom7DayLater + "' , NULL, NULL)";
		List<Object> param = new ArrayList<>();
		param.add(inputBookNo);
		param.add(id);

		return jdbc.update(sql, param);
	}

	public int loanBookTable(String inputBookNo, String id) {
		String sql = "UPDATE BOOK SET  BK_LDSNO = ?, BK_LDCNT = BK_LDCNT + 1, BK_RSVSNO = NULL  WHERE BK_NO = ?";
		List<Object> param = new ArrayList<>();
		param.add(id);
		param.add(inputBookNo);

		return jdbc.update(sql, param);
	}
	
	public Object studentSelectSTDNAME(String std_no, String columnName) {
		String sql = " select * from student where std_no=? ";
		Object param = std_no;
		
		return jdbc.selectOneValue(sql, param, columnName);
	}

	////////////////////////////////////////////// [������]////////////////////////////////////////////
	// �л��� �й��� �����ϴ���, �ִٸ� ������ ����ϴ� �޼ҵ�
	public Object verifyStudentNo(String studentNo) {

		
		Object param = studentNo;
		String columnName = "STD_NO";

		return jdbc.isDuplicateSTD(param, columnName);
	}

	public Object getStdate(Object id) {

		
		Object param = id;
		String columnName = "STD_STDATE";

		return jdbc.isDuplicateSTD(param, columnName);
	}

	public Object verifyBookNo(String inputBookNo) {

		Object param = inputBookNo;
		String columnName = "BK_NO";

		return jdbc.isDuplicateBK(param, columnName);
	}
}

class LoanService {
	
	
}
