package chap07.sec05;

public class ContentSenderExample {

	public static void main(String[] args) {
		ContentSender c1 = new KakaoSender ("ȸ�İ���", "����", "���� 19��");
		c1.sendMsg("ȫ�浿");

//		�Ǵ� �̷���
//		KakaoSender ks = new KakaoSender ("ȸ�İ���", "����", "���� 19��");
//		ks.sendMsg("ȫ�浿");
		
		System.out.println();
		Letter l1 = new Letter("����", "ȸ��","���� 20�� �Ҽ���");
		l1.sendMsg("ȫ���");
		
	}

}
