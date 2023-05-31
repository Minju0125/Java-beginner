package chapter11.sec02;

public class TempVO { // ������ Ȯ���ϰ� �����ϴ� ����. �����ϴ� �޼ҵ�� x / setter, getter, private(���Ǵ�κ�) ��������� ���� -> �ۿ��� �������� ���ϵ��� , �׷��� ���Ͱ��� ���� ��
	// ���� : �����ͺ��̽��κ��� ������ ������ ��� ����, �ش� �����ͺ��̽� �÷��� ���ƾ���.
	// getter  �޼ҵ带 ���ؼ� insert �� ������ ����
	// VO Ŭ������ �������� Ŭ����
	
	
	private String empNo; // ��������� �� Ŭ������ Ư¡�� �����ִ� ��
	private String eName;
	private String job;
	private int deptNo;
	//���� �� ��������� ������. (setter �޼ҵ带 ����)
	//������� ���� ��ü�� �Ҹ�ɶ����� ������
	
	// private ���� �����Ǿ� ������ �ܺο��� �ʱⰪ ������ �� ���� ������ ��κ� ������ �޼ҵ带 �̿�.
	// �ٵ� ���⼱ �ٸ��� �� ����
	
	private static TempVO instance = null; // �̱��� ������ �����ϱ� ���� �ڵ� // ��ü�� �ּҰ��� ����� instance �� �������
	// static method ���� �ҷ��� ���Ŷ� �굵 static ���� ����
	
	// �̱��� ������ Ŭ������ �ν��Ͻ��� ���� �ϳ��� �����ϵ��� �����ϴ� ������ ����
	
	//������ �޼ҵ� ������ �����Ǵ°� �ƴ϶� ������ �޼ҵ� ���� �ʿ����
	
	TempVO() {} // �⺻ ������ �޼ҵ� 
	
	public static TempVO getInstance() { // ��κ� getInstance��� �̸� ����
		if(instance == null) instance =new TempVO(); // �����س��� �ѹ��� �Ƚ����ϱ�.
		return instance; // ��ȯŸ���� �ڱ��ڽ� Ŭ����Ÿ�� 
		// �� �ѹ��� �ϱ� ������.
		
		//��Ŭ�� �ܺο��� �� Ŭ���� ��ü�� �ҷ��� ������ ��ü�� heap �޸𸮿� ��ü �ϳ��� 
		// ��ü�� �� �ϳ��� ����
	}

	public String getEmpNo() {
		return empNo; // ��������� ���� �ܺη� ������ ������ return . �Ű����� ���ʿ�
	}

	public void setEmpNo(String empNo) { // �ܺηκ��� ������ �޾ƾ��ϱ� ������ �Ű����� �����ؾ���.
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
		return empNo + "  " + eName + "  " + job + "  " + deptNo; // ���ι��ڿ��� ��ȯ�ؼ� �ϳ��� ��� ���� (toString)
	} //VO Ŭ���� ��ü ������ ����Ǵ� �� 
	//TempDao Ŭ�������� list.add(tempVO); �ϱ� ���� �̰Ÿ� ����. -> �ѹ������� �����ؼ� ����ϱ� ����
	//��ü�� ������ �ִ� ������ ���ڿ��� ���.
	//����� �ϳ��� ���ڿ��� tempVO �� �����.
	//Ŀ���� ����� ������ ���� source �޴� ����
	//���ٴ����� ����. 
	
	
}
