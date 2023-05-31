package chapter11.sec02;

public class TempVO { // 정보를 확인하고 저장하는 역할. 조작하는 메소드는 x / setter, getter, private(거의대부분) 멤버변수만 존재 -> 밖에서 접근하지 못하도록 , 그래서 세터게터 쓰는 것
	// 목적 : 데이터베이스로부터 정보를 꺼내서 담는 목적, 해당 데이터베이스 컬럼과 같아야함.
	// getter  메소드를 통해서 insert 로 데이터 제공
	// VO 클래스는 컨테이터 클래스
	
	
	private String empNo; // 멤버변수는 그 클래스의 특징을 지어주는 값
	private String eName;
	private String job;
	private int deptNo;
	//여기 이 멤버변수에 저장함. (setter 메소드를 통해)
	//멤버변수 값은 객체가 소멸될때까지 존재함
	
	// private 으로 지정되어 있으면 외부에서 초기값 저장할 수 없기 때문에 대부분 생성자 메소드를 이용.
	// 근데 여기선 다르게 할 것임
	
	private static TempVO instance = null; // 싱글톤 패턴을 구현하기 위한 코드 // 객체의 주소값이 저장된 instance 가 멤버변수
	// static method 에서 불러다 쓸거라 얘도 static 변수 선언
	
	// 싱글톤 패턴은 클래스의 인스턴스가 오직 하나만 존재하도록 보장하는 디자인 패턴
	
	//생성자 메소드 가지고 생성되는게 아니라 생성자 메소드 굳이 필요없음
	
	TempVO() {} // 기본 생성자 메소드 
	
	public static TempVO getInstance() { // 대부분 getInstance라고 이름 붙임
		if(instance == null) instance =new TempVO(); // 생성해놓고 한번도 안썼으니까.
		return instance; // 반환타입이 자기자신 클래스타입 
		// 딱 한번만 하기 때문에.
		
		//싱클톤 외부에서 이 클래스 객체를 불러다 쓰더라도 객체는 heap 메모리에 객체 하나만 
		// 객체를 딱 하나만 만듦
	}

	public String getEmpNo() {
		return empNo; // 멤버변수의 값을 외부로 빼내기 때문에 return . 매개변수 불필요
	}

	public void setEmpNo(String empNo) { // 외부로부터 데이터 받아야하기 때문에 매개변수 존재해야함.
		this.empNo = empNo;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	
	@Override
	public String toString() {
		return empNo + "  " + eName + "  " + job + "  " + deptNo; // 전부문자열로 반환해서 하나로 묶어서 전달 (toString)
	} //VO 클래스 객체 변수에 저장되는 값 
	//TempDao 클래스에서 list.add(tempVO); 하기 위해 이거를 쓴것. -> 한묶음으로 저장해서 출력하기 위해
	//객체가 가지고 있는 정보를 문자열로 묶어서.
	//저장된 하나의 문자열이 tempVO 에 저장됨.
	//커서를 빈곳에 가져다 놓고 source 메뉴 선택
	//한줄단위로 저장. 
	
	
}
