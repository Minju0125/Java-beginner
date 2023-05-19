package chapter06.sec06;

public class Member {
	private String name;
	private String id;
	private String passwd;
	private int age;
	
	public Member() {}
	public Member(String name, String id, String passwd, int age) {
		this.name = name;
		this.id = id;
		this.passwd = passwd;
		this.age = age;
	}

	public String getId() {
		return id;
		
	}
	
	public String getPasswd() {
		return passwd;
		
	}
	
}
