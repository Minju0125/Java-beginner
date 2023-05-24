package chap07.sec05;

public class KakaoSender extends ContentSender {
	String content;

	KakaoSender(String title, String senderName, String content) {
		super(title, senderName);
		this.content = content;

	}

	@Override
	public void sendMsg(String recripient) {
		System.out.println(" 제목 : " + title);
		System.out.println(" 이름 : " + senderName);
		System.out.println(" 내용 : " + content);
		System.out.println(" 수신자 : " + recripient);

	}

}
