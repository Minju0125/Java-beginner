package chap02.sec01;

public class VariableExample01 {
	static int days; // �������?
	public static void main(String[] args) {
		Variable02 var2 = null; 	// Variable02 : Ŭ���� 
									// Ÿ�Ը� ������ / var2�� ���������� (4���� �ϱ�. �迭/Ŭ����/�������̽�/enum?), ������������ �ּ� ���
									// null ���̸� ���� �ʴ� ���ڿ� ������ , �����Ͱ� �������� �ʴ� ���� ("" <- �̰͵� null , white space�̶�� ��, ���ڿ��� �ʱ�ȭ��ų�� ���)
		var2 = new Variable02(); // Variable02() : �ڿ� ��ȣ ������ ������ �޼���( �����ϰ� �빮�ڷ� �����ϴ� �޼���) / new �� �ּ� ������-������
//		var2.value1=100;
//		value1=100;
		System.out.println(var2.Value1);
		
/*		int sum = 0; 
		int days = 0;
		int amountMoney = 100;
		while(true) {
			days++;
			sum = sum + amountMoney;
			if(sum>=1000000) { break; }
			amountMoney=amountMoney*2;
		}
		// ���� �޼��尡 ���ԵǾ��� Ŭ������ �տ��� �ۺ� ���� �� ����, ���θ޼���� �ϳ��� �� �� ����
		System.out.println("����ϼ� : " + days);
		System.out.println("����ݾ� : " + sum);
	*/ 
		}
	
}

class Variable02{
	int Value1; //������� , �ٸ� Ŭ������ �ִ°� ����پ����� Ŭ������ ��ü�� ����ؾ��� -> ���� ����, // �ڵ��ʱ�ȭ
}
// class Vairable02 ��� Ŭ������ �ϳ� �� ���� ���θ޼���� ���� �ִ� ���̱� ������ (�ۺ�) -> �����̸��� ���θ޼��尡 ���Ե� Ŭ�������� �����

