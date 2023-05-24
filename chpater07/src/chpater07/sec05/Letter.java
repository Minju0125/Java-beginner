package chap07.sec05;

public class Letter extends ContentSender { // 추상클래스를 상속받음
	String content;

	Letter(String title, String senderName, String content) {
		super(title, senderName);
		this.content = content;
	}
	
	@Override
	public void sendMsg(String recripient) {
		System.out.println(" 내용 : " + content);
		System.out.println(" 수신자 : " + recripient);
	}

}
