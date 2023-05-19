package chapter06.sec01;

public class EmployeeExample {

	public static void main(String[] args) {
		Employees emp1 = new Employees() ; //사용할 수 있는 모양은 기본 생성자 모양 밖에 없음
		emp1.empId =1001; // 디폴트로 선언해놓았기 때문에 정수로 지정가능
		emp1.empName = "강감찬";
		emp1.telNum = "010-1234-5678";		//다른 곳에서 데이터를 직접 정의하는게 좋은 방법은 아님
	
		emp1.showEmpInfo();
	
	}

}
