package chapter08.sec01;

public class OracleDao implements DataAccessObject { 
	//�� Ŭ������ DataAccessObject �� ������ -> implements
	//�������̽��� Ȯ���ڴ� .java�� // Ŭ������ �ƴ� !
	
	@Override
	public void select() {// �θ��������̽��κ��� ��ӹ��� ->> @Override 
						  //�������̵� �ȵǸ� ����� ��ü �� �� ���� !
		System.out.println("Oracle DB���� ������ �˻�");
	}
	
	@Override
	public void insert() {
		System.out.println("Oracle DB���� �ڷ� ����");
		
	}
	
	@Override
	public void update() {
		System.out.println("Oracle DB���� �ڷ� ����");
	}
	
	
	
	@Override
	public void delete() {// �� �߿� �ϳ��� ���������� �ʰڴ� �ϸ� class �տ� abstract �پ����
		System.out.println("Oracle DB���� �ڷ� ����");
	} 

}
