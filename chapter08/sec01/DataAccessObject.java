package chapter08.sec01;

public interface DataAccessObject {
	public void select(); //DML 명령할 수 있는 메소드// abstract 가 다 생략되었음. 안써도 자동으로 들어가서 잘 안씀 
	public void insert();
	public void update();
	public void delete();
	

}
