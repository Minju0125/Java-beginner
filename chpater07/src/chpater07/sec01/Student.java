package chpater07.sec01;

public class Student extends People { 
	private String ssn;
	
	Student(String name, int age, String gender, String ssn) {
		super(name, age, gender); // �θ�Ŭ������ ������ �� �ʿ��� ��.
		this.ssn = ssn;
	}
	
	
	
}
