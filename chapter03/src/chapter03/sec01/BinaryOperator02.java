package chapter03.sec01;

public class BinaryOperator02 {

	public static void main(String[] args) {
		// ��Ʈ, ����, �̵� => ���׿�����
//		bitwiseOperator();
		shiftOperator();

	}

	public static void bitwiseOperator() {
		// ��Ʈ�� ������ : |, %, ^
		int n1 = 35;
		int n2 = 23;
		System.out.println("n1 & n2 = " + (n1 & n2));
		System.out.println("n1 | n2 = " + (n1 | n2));
		System.out.println("n1 ^ n2 = " + (n1 ^ n2));

	}

	public static void shiftOperator() {
		// �̵�������: shiftOperator
		// shift : >>(right shift), <<(left shift)
		// , >>> (right shift with sigh bit)

		int num = 35;

		System.out.println("35>>2 = " + (num >> 2));
		System.out.println("35<<2 = " + (num >> 2));

		num = -35; // �̰� �𸣰��� !@
		System.out.println("35>>>2 = " + (num >>> 2));

	}

	public static void assignOperator() {
		// ���� : =, �켱 ������ ���� ����
		// ���մ��Կ����� : +=. -=, /=. *=, %=
		// ���1) ���� = ���� ������ (+,-,/,*) �� 							// ������� ����Ǵ� �����Ұ� ���꿡�� ���
		// ���2) ���� ������ = ��
		
		int res = 0;
		int num = 100;
		
		res = res+10; // res + = 10 ; 
		
		res = res * (num/10); // ��ȣ ���� ��
		res *= (num/10);
		
		
		
	}

}
