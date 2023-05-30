package chapter11.sec01;
//StringBuffer, StringBuilder : String Ŭ������ ���� (immutable)
//�� ������ Ŭ����
//append() �޼��带 �̿��Ͽ� ����� ���ڿ� ���� ���ο� ���ڿ� �߰� ����
//���� �� toString() �� �̿��Ͽ� ���ڿ� (String) Ÿ������ ��ȯ

public class StringBufferExample {

	public static void main(String[] args) {
		
		StringBuffer sb = new StringBuffer();
		
		StringBuffer sb1 = new StringBuffer("ȫ�浿"); // ���ڿ��� ���� �����ؼ� �����ص� ��
		StringBuffer sb2 = new StringBuffer("ȫ�浿");
		
//		if(sb1.equals(sb2)) {
//			System.out.println("���� ����");
//		} else {
//			System.out.println("�ٸ� ����");
//		} // toString �� ������ �Ǿ����� �ʱ⶧����, �ּҰ����� �Ǵ��ϴµ�. (�ٸ����� ���)
		// equals �޼ҵ忡 ���� ����� �Ұ�����.
		// ������Ϸ��� toString
		
		if(sb1.toString().equals(sb2.toString())) {
			System.out.println("���� ����");
		} else {
			System.out.println("�ٸ� ����");
		} // ������ �ȵǸ� getClass ~��¼���� ��ȯ (�ּҰ�) 
		//���ڿ��� �ٲ㼭 �����ϴ� execute ������ ~��¼�� ������ ��������� ���������� ������.
		//������ ��쿡�� toString ����� �� ������, 
		//������ ������ ��쿡�� StringBuffer, StringBuilder �� �ַ� �����.
		
		sb.append("  select * \n  "); // append �μ��� ���޵� ���� ���ڿ��� ��ȯ�� ��, �ش� ���ڿ��� �������� �߰�
		sb.append("  from member \n  ");
		sb.append("  where mem_id = ?  ");
		// ������ ����� �����.
		// append() �� ������� �� ���� �߰��ϴ� �޼ҵ�
		// ""�ȿ��� �ϳ� �̻��� ������ �������ִ� ���� ������ ��� - > �ٿ��� ����ϰ� �Ǹ� ���� ���� �� ���� �� ����. -> �ٵ�, ����Ŭ�� ���鿡 ���� ���еǱ� ������
		// ���� �Ǵ� \n�� �̿��ؼ� ����
		// �����ȿ�  
		
		
		//String Ÿ���� �ƴѵ�, ���� ������ ���ؼ��� �ݵ�� �Ű������� String Ÿ���̾����
		//�׷���, toString ��
		String str = sb.toString();
		System.out.println(str);
	
	}
}
