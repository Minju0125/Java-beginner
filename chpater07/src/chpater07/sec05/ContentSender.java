package chap07.sec05;

public abstract class ContentSender { // �Ϲ�Ŭ���� ����� Ŭ���� �տ� abstract ����
	String title;
	String senderName;
	
	ContentSender(){}
	ContentSender(String title, String senderName) {
		this.title = title;
		this.senderName = senderName;
		
	}
	
	public abstract void sendMsg(String content);
	
}
