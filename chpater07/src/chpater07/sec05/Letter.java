package chap07.sec05;

public class Letter extends ContentSender { // �߻�Ŭ������ ��ӹ���
	String content;

	Letter(String title, String senderName, String content) {
		super(title, senderName);
		this.content = content;
	}
	
	@Override
	public void sendMsg(String recripient) {
		System.out.println(" ���� : " + content);
		System.out.println(" ������ : " + recripient);
	}

}
