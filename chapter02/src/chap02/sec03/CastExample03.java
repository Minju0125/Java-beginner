package chap02.sec03;

public class CastExample03 {

	public static void main(String[] args) {

//		[문제] 1년은 365.2422일이다. 이 자료로
//        "1년은  365일   xx 시간  xx분  xx초 이다"를 출력하도록 프로그램 하시오....

		System.out.println(0.2422 * 24);
		System.out.println(0.8128 * 60);

		int hour = (int) (0.2422 * 24);
		System.out.println(hour);

		int minute = (int) (((0.2422 * 24) - (double) hour) * 60);
		System.out.println(minute);

		int second = (int) (((((0.2422 * 24) - (double) hour) * 60) - (double) minute) * 60);
		System.out.println(second);

		System.out.println("1년은 365일 " + hour + "시간 " + minute + "분 " + second + "초 이다.");

	}

}
