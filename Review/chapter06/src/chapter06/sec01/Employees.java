package chapter06.sec01;
// �����ȣ(int Ÿ���� ����), �����, ��ȭ��ȣ�� ������
// ���Ŭ���� �� �ۼ��Ͻÿ�, ����� �����ȣ ��� ���Ӵ�
public class Employees {
	// �̹����� ����Ʈ������ �غ���~
	// �̹����� ������ �޼ҵ� ���� �ʰ� �غ���~
	int empId; 
	String empName;
	String telNum; 
	
	public void showEmpInfo() { // ��� ������ �����ִ� �޼ҵ�
		System.out.println("-------------------------------------");
		System.out.println("�����ȣ	�����	��ȭ��ȣ	");
		System.out.println("-------------------------------------");
		System.out.println("");
		System.out.printf("%5d	 %4s   %15s", empId, empName, telNum);
		
		
	}
	
}
