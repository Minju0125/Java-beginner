package chapter06.sec01;

public class EmployeeExample {

	public static void main(String[] args) {
		Employees emp1 = new Employees() ; //����� �� �ִ� ����� �⺻ ������ ��� �ۿ� ����
		emp1.empId =1001; // ����Ʈ�� �����س��ұ� ������ ������ ��������
		emp1.empName = "������";
		emp1.telNum = "010-1234-5678";		//�ٸ� ������ �����͸� ���� �����ϴ°� ���� ����� �ƴ�
	
		emp1.showEmpInfo();
	
	}

}
