package chapter03.sec01;

public class UnaryOperator {

	public static void main(String[] args) {
		// ���׿����� : ��ȣ(+,-), ���� (++,--), ������ (!)

		// ���θ޼ҵ尡 ������ ��ü ���α׷��� ����

//		signOperator(); // �Ʒ� void �����Ű�� ���� ���� -> ���⼭ ���� ������ ���θ޼ҵ� �����̱� ������ ���� ��.
		// ��ȯ���� ������ ���� void -> �޼ҵ� �̸��� �θ���
		// �Ʒ��� �����Ű�� ���θ޼ҵ�� �ٽ� ���ƿ� (�޼ҵ��� ȣ����)

//		incrementOperator()
		
		
		logicalNot();

	}

	public static void signOperator() { // ��ȣ�����ϱ� �޼ҵ� -> �ڿ� �߰�ȣ�� �޼ҵ��� ����
		// ��ȣ������ : ����(-), ���(+)
		int num1 = 100;
		int num2 = -num1;

		// (����) 1-2+3-4.......-10=?
		// ���⼭ ��Ģ�� ���ڰ� 1~10���� ����
		// ��ȣ�� +, - �����Ƴ���
		// � ���� -1�� ���� ����ؼ� -1�� ���Ϥ���
		// -1�� �����ִµ� ù ���� -1�̾����

		System.out.println("num1=" + num1); // ���ڿ� + �ִ�Ÿ�� -> ���ڷ� // num1�� ���� // ���ڿ��� ����ϰ� �ٹٲټ���.//�����ҿ� ����� ���� ���ڿ��� ��
		System.out.println("num2=" + num2);

	}

	public static void incrementOperator() { // incrementOperator() ��� �޼��带 ���� ���θ޼ҵ忡�� �ҷ�����!!!!

		// ���������� : ++, --,
		int num = 100;
		int res1 = 0; // result : res
		int res2 = 0;

//		res1 = num++; //num�� ����ִ� 100�� res1�� �ְ� 1���� // postfix ǥ����
//		System.out.println("num=" + num + "\nres1="+res1);

		System.out.println("num++=" + (num++) + "num=" + (num));
		// ���� num�� ����ִ� ���� �־��� (���� �ڱ� �ڽ��� ���� ��, res1 ����) �׸��� 1 �������Ѽ� ���� �־���

		num = 100;
//		res2 = ++num; // prefix ǥ����
//		System.out.println("num=" + num + "\nres2="+res2);
//		
		System.out.println("++num" + (++num) + "num=" + num);

	}

	public static void logicalNot() {
		// �� ���� ������ : ! (Not)
		// ��۱�� (toggle) : ���� ������ �ݺ��Ǵ� ���
		// �ѿ���ȯ, ����/������� ��

		boolean powerState = true;
		while (true) { // ���ѷ��� ���� �� - while : �� �߰�ȣ�� �ִ� ��ɹ��� �ݺ��Ͻÿ� (���ΰ��- ���ѷ���), 
			if (powerState) { // ��ȣ�ȿ� �ִ°� ���̶��
				System.out.println("���� ����ġ�� on ����"); 
			} else { 
				System.out.println(" ���� ����ġ�� off ����");
			}
			powerState = !powerState; // powerState ���� ���̸� ��������, �����̸� ������ // ����ڰ� ������ �� ����  
		}

	}

}
