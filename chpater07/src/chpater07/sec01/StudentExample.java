package chpater07.sec01;

public class StudentExample {

	public static void main(String[] args) {
		Student s1 = new Student ("홍길동", 25, "여성", "abc@naver.net");
		
		System.out.println("학생명 : " + s1.name); 
		System.out.println("나이 : " + s1.age); 


		People p2 = new People ("강감찬", 30, "남성");
		
		
	}

}
