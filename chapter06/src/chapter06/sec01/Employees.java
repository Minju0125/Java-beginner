package chapter06.sec01;
// 사원번호(int 타입의 정수), 사원명, 전화번호를 보유한
// 사원클래스 를 작성하시오, 기능은 사원번호 출력 가ㅣ능
public class Employees {
	// 이번에는 디폴트형으로 해보자~
	// 이번에는 생성자 메소드 쓰지 않고 해보기~
	int empId; 
	String empName;
	String telNum; 
	
	public void showEmpInfo() { // 사원 정보를 보여주는 메소드
		System.out.println("-------------------------------------");
		System.out.println("사원번호	사원명	전화번호	");
		System.out.println("-------------------------------------");
		System.out.println("");
		System.out.printf("%5d	 %4s   %15s", empId, empName, telNum);
		
		
	}
	
}
