package chapter06.sec01;

public class TvExample {
//����5 ] 
//	main �޼ҵ带 ��������� �� ����ȸ��, ����⵵, ũ�⸦ ����ϴ� TV Ŭ������ �ۼ��Ͻÿ�
//	-tvŬ������ ��ũȣ�� Ŭ����
//	-���� ����ϴ°� ��ġ Ŭ����

	public static void main(String[] args) {
		PrintTv p1 = new PrintTv("�Ｚ", 2023, "300x200");
		System.out.println(p1);

//		PrintTv p2 = new PrintTv();
//		p2.setCompany("LG");
//		p2.setYear(2020);
//		p2.setWide("150x200");
//		System.out.println(p2);
		/*
		 * ��
		 * ���� ������ public PrintTv() { }
		 * 
		 * public PrintTv(String company, int year, String Wide) { this.company =
		 * company; this.year = year; this.wide = wide; }
		 *  * �̷��� �����
		 * 
		 */

	}
}

class PrintTv {
	private String company;
	private int year;
	private String wide; // ������� �ְ�, ���� ���� �־����

	// ��ü���� ����� �ַ� ������ �޼ҵ�
	//
	// ��� ������ � �ȵ� ������ �������̵� �� ��Ʈ�� �ᵵ ��
	// �ʹ� ������� ������ ��¸޼ҵ� �ۼ��ϴ°� ����

//	public PrintTv() { // -> �̰� �� �ϴ���?
//	} // ������ �����ε��� Ŭ���� �̸��� �������� �̸��� ���ƾ� �Ѵ�. 

	public PrintTv(String company, int year, String Wide) {
		this.company = company;
		this.year = year;
		this.wide = wide;
	} // public PrintTv() �ΰ��� ����� �� �𸣰���

//	public void setCompany(String company) {
//		this.company = company;
//	}
//
//	public void setYear(int year) {
//		this.year = year;
//	}
//
//	public void setWide(String wide) {
//		this.wide = wide;

	// �̰� �� �ϴ���

	// this, ovveride??

	@Override
	public String toString() {

		return "����ȸ�� : " + company + "\n�⵵ : " + year + "\nũ�� : " + wide;
	}

}
