package util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOConnection {
	/* ��ȭ�� �������� localhost�� �����ؼ� ����ؾ��� Ȯ�ο�� */
	private final String URL = "jdbc:oracle:thin:@192.168.35.55:1521:xe";
	private final String USER = "pc13_p2"; // ��ȭ�� ������..
	private final String PASSWD = "java";

	private static DAOConnection instance = null;

	private DAOConnection() {}

	public static DAOConnection getInstance() {
		if (instance == null) instance = new DAOConnection();
		return instance;
	}
			/* 0615 10:23 �輮ȣ �������� 
			 * conn���� static ����
			 */
	public Connection conn = null;
	public Statement stmt = null;
	public PreparedStatement pstmt = null;
	public ResultSet rs = null;
	public CallableStatement cstmt = null;
	
	public void connectConn() {
		/*
		 * ���⼭ clearConsole ȣ���ϰų� connetConn �ҷ����� ���� clearConsole ȣ���Ұ�
		 */

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWD);
			stmt = conn.createStatement();
			stmt.executeUpdate("UPDATE STUDENT SET STD_STDATE = NULL WHERE STD_STDATE < SYSDATE");
			stmt.execute(" select ascii_seq.nextval from dual ");
			stmt.execute(" alter sequence ascii_seq increment by -1 ");
			stmt.execute(" select ascii_seq.nextval from dual ");
			stmt.execute(" alter sequence ascii_seq increment by 1 ");
			
			
			System.out.println("����Ǿ����ϴ�.");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("���� �ɰ��� ������ �߻��߾��");
		}
	}

	public void disconectConn() {
		if (rs != null)	try {rs.close();} catch (Exception e) {}
		if (stmt != null)try {stmt.close();} catch (Exception e) {}
		if (pstmt != null)try {pstmt.close();} catch (Exception e) {}
		if (conn != null)try {conn.close();} catch (Exception e) {}
		System.out.println("���� �����Ǿ����ϴ�.");
	}
}
