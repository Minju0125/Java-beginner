package chap07.sec05;

public abstract class ContentSender { // 일반클래스 만들고 클래스 앞에 abstract 붙임
	String title;
	String senderName;
	
	ContentSender(){}
	ContentSender(String title, String senderName) {
		this.title = title;
		this.senderName = senderName;
		
	}
	
	public abstract void sendMsg(String content);
	
}
