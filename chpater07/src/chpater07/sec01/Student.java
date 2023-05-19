package chpater07.sec01;

public class Student extends People { 
	private String ssn;
	
	Student(String name, int age, String gender, String ssn) {
		super(name, age, gender); // 부모클래스가 생성될 때 필요한 것.
		this.ssn = ssn;
	}
	
	
	
}
