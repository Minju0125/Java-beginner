package kr.or.ddit.study.study05_06;

import java.util.Scanner;

public class MovieManagementSystem {

	String selectName = "";
	int selectMovie = 0;
	String selectMovieName = "";
	String selectSeatNumber = "";
	boolean flag = false;
	int money = 50000;

	String[] movie = new String[] { "리미트", "범죄도시", "서울대작전", "토르: 러브앤썬더", "헤어질결심", "카터", "엄마", "마녀2" };
	int[] moviePrice = { 12000, 14000, 10000, 14000, 12000, 11000, 10000, 12000 };

	// 좌석현황
	String[][] seat = new String[4][10];
	String[][] seatGuide = new String[4][10]; // 남은 좌석 번호 공간
	String[] seatLine = { "a", "b", "c", "d" }; // 각 열 Line

	public MovieManagementSystem() {
		for (int i = 0; i < seat.length; i++) {
			for (int j = 0; j < seat[i].length; j++) {
				seat[i][j] = "-";
			}
		}

		for (int i = 0; i < seatGuide.length; i++) {
			for (int j = 0; j < seatGuide[i].length; j++) {
				// a-1, a-2, a-3
				seatGuide[i][j] = seatLine[i] + "-" + j;
			}
		}

		// 예매 데이터(dummy)
		seat[0][1] = "유재석-리미트-a-1";
		seat[0][2] = "박명수-리미트-a-2";
		seat[2][4] = "정준하-카터-c-4";
		seat[3][9] = "정형돈-마녀-d-9";
	}
///////////

	// MovieMain 클래스에서 호출되어 시작될 함수(기능)
	public void start() {
		System.out.println("대덕 CGV");
		while (true) {
			System.out.println("■■MAIN MENU");
			System.out.println("■1.예매하기");
			System.out.println("■2.조회하기");
			System.out.println("■3.취소하기");
			System.out.println("■4.나가기");
			System.out.println();
			System.out.println("::: 메뉴를 선택해주세요.");
			System.out.println("선택 : ");

			Scanner sc = new Scanner(System.in);
			int menu = sc.nextInt();
			System.out.println();

			switch (menu) {
			case 1:
				ticketing(); // 예매하기
				break;
			case 2:
				break; // 조회하기
			case 3:
				break; // 취소하기
			case 4:
				// 나가기
				System.out.println("■ 이용해주셔서 감사합니다!");
				System.out.println("■■■■ 대덕 GCV ■■■■");
				flag = true;
				break;
			default:
				System.out.println("■ 메뉴를 정확하게 입력해주세요!");
			}

			System.out.println();
			System.out.println();

			if (flag) {
				System.exit(0);
			}

		}

	}

	public void ticketing() {
		Scanner sc1 = new Scanner(System.in);
		System.out.println("■■ [영화예매하기]");
		System.out.println("■■ ::: 예매하시는 본인의 이름을 적어주세요");
		System.out.println("[이름 : ");
		selectName = sc1.nextLine(); // 이름저장

		System.out.println();
		System.out.println("::: 영화를 선택해주세요.");
		System.out.println("■■ [Movie]");

		// 영화 목록 출력
		for (int i = 0; i < movie.length; i++) {
			System.out.println(i + ". " + movie[i]);

		}

		System.out.println("[영화 : ");
		selectMovie = sc1.nextInt();
		System.out.println();

		for (int i = 0; i < movie.length; i++) {
			if (selectMovie == i) {
				System.out.println("[" + movie[i] + "] 선택완료되었습니다! \n");
				selectMovieName = movie[i];

			}
		}

		System.out.println();
		System.out.println("::: 좌석을 선택해주세요");

		for (int i = 0; i < seat.length; i++) {
			for (int j = 0; j < seat[i].length; j++) {
				if (!seat[i][j].equals("-")) {
					System.out.print("■");
				} else {
					System.out.print("□");
				}
				if (j == 3 || j == 7) {
					System.out.print(" ");
				}
				
			}
			System.out.println();
		}
		System.out.println("──────────────────────────────────");

		// 좌석 가이드 확인하기(a-1, a-2, a-3, ... 자리)
		for (int i = 0; i < seatGuide.length; i++) {
			for (int j = 0; j < seatGuide[i].length; j++) {
				if (!seat[i][j].equals("-")) {
					System.out.print("XXX ");
				} else {
					// a-1,a-2...
					System.out.print(seatGuide[i][j] + " ");
				}
				if (j == 3 || j == 7) {
					System.out.print(" ");
				}
			}
			System.out.println();
		}

		System.out.println("[좌석 : ");
		String selectSeat1 = sc1.nextLine();
		String selectSeat = sc1.nextLine();
		System.out.println();
		
		/*
		 * 사용자가 입력하고 선택한 이름, 영화, 좌석 데이터를 이용하여 영화 예매를 진행
		 * */
		
		String[] arr = selectSeat.split("-");
		String seatId = arr[0];
		int seatNum = Integer.parseInt(arr[1]);
		
		//최종 이름, 영화, 좌석번호를 이용하여 영화 예매정보를 기록합니다.
		for (int i = 0; i<seat.length; i++) {
			if(seatId.equals(seatLine[i])) {
				seat[i][seatNum] = selectName + "-"
						+ selectMovieName + "-" +selectSeat;
			}
		}
		
		System.out.println("::: 결제를 진행합니다...");
		for (int i = 0; i<10; i++) {
			System.out.print("■"); 
			try {
				Thread.sleep(100);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(" 100%");
		System.out.println();
		
		money -= moviePrice[selectMovie];
		System.out.println("■ 결제가 완료되었습니다.");
		System.out.println();
		System.out.println("■■예매가 완료되었습니다.");
		System.out.println("■ 이름 : " + selectName);
		System.out.println("■ 영화 : " + selectMovieName);
		System.out.println("■ 좌석 : " + selectSeat);
		System.out.println("■ 잔액 : " + money);
		
		
		
		
		
	}

}
