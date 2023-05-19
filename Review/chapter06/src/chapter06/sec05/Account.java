package chapter06.sec05;
// �̱��� �� �ܿ�~
public class Account { // �̱����� ���
	private static Account ac = null; // ��ī��Ʈ Ŭ���� Ÿ������������
	private Account() {}		// ��ü�� �����Ǳ� ������ ���� �ִ� �������� (static)
	
	// ����ƽ ���� ���� ��ü�� �������� �ʴµ�, ȣ��Ǿ���ϴϱ� ����ƽ ����
	public static Account getInstance() {  // ��ȯŸ���� �ڱ� �ڽ��� Ŭ���� Ÿ��- �̸��� ���� geInstance �� ���
		if(ac == null) ac =  new Account();		 //account == null �̸� ���� �ڽ��� ��ü�� �������� �ʾҴ�.
		return ac;
}
}


/*
account ��� �ϴ� ������ �޼ҵ忡���ƿ� null.
private Account() {}	-> private���� ������ �޼ҵ�
�ܺο��� �ҷ��� �� �� ���, �ܺο��� �ҷ��� �� �� �ִ� getInstance() �޼ҵ� ���� -> ��ȯ Ÿ���� Ŭ����Ÿ�� 
					-> �ٵ� �굵 static
				if ����. account �� null �̸� ���ο� Ŭ���� ��ü ���� (heap��. new �ϱ�)
								�� �ּҸ� null ���� ����ִ� �޼ҵ� �������� account �� . 
								�긦 �θ� �ʿ� account ������ Account Ŭ���� Ÿ��.
*/

