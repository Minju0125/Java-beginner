package chap07.sec05;

public class ContentSenderExample {

	public static void main(String[] args) {
		ContentSender c1 = new KakaoSender ("회식공지", "반장", "오늘 19시");
		c1.sendMsg("홍길동");

//		또는 이렇게
//		KakaoSender ks = new KakaoSender ("회식공지", "반장", "오늘 19시");
//		ks.sendMsg("홍길동");
		
		System.out.println();
		Letter l1 = new Letter("공지", "회장","오늘 20시 소선생");
		l1.sendMsg("홍길순");
		
	}

}
