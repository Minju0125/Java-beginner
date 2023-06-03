package kr.or.ddit.study.study05_06;

import java.util.Scanner;

public class MovieManagementSystem {

	String selectName = "";
	int selectMovie = 0;
	String selectMovieName = "";
	String selectSeatNumber = "";
	boolean flag = false;
	int money = 50000;

	String[] movie = new String[] { "����Ʈ", "���˵���", "���������", "�丣: ����ؽ��", "��������", "ī��", "����", "����2" };
	int[] moviePrice = { 12000, 14000, 10000, 14000, 12000, 11000, 10000, 12000 };

	// �¼���Ȳ
	String[][] seat = new String[4][10];
	String[][] seatGuide = new String[4][10]; // ���� �¼� ��ȣ ����
	String[] seatLine = { "a", "b", "c", "d" }; // �� �� Line

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

		// ���� ������(dummy)
		seat[0][1] = "���缮-����Ʈ-a-1";
		seat[0][2] = "�ڸ��-����Ʈ-a-2";
		seat[2][4] = "������-ī��-c-4";
		seat[3][9] = "������-����-d-9";
	}
///////////

	// MovieMain Ŭ�������� ȣ��Ǿ� ���۵� �Լ�(���)
	public void start() {
		System.out.println("��� CGV");
		while (true) {
			System.out.println("���MAIN MENU");
			System.out.println("��1.�����ϱ�");
			System.out.println("��2.��ȸ�ϱ�");
			System.out.println("��3.����ϱ�");
			System.out.println("��4.������");
			System.out.println();
			System.out.println("::: �޴��� �������ּ���.");
			System.out.println("���� : ");

			Scanner sc = new Scanner(System.in);
			int menu = sc.nextInt();
			System.out.println();

			switch (menu) {
			case 1:
				ticketing(); // �����ϱ�
				break;
			case 2:
				break; // ��ȸ�ϱ�
			case 3:
				break; // ����ϱ�
			case 4:
				// ������
				System.out.println("�� �̿����ּż� �����մϴ�!");
				System.out.println("����� ��� GCV �����");
				flag = true;
				break;
			default:
				System.out.println("�� �޴��� ��Ȯ�ϰ� �Է����ּ���!");
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
		System.out.println("��� [��ȭ�����ϱ�]");
		System.out.println("��� ::: �����Ͻô� ������ �̸��� �����ּ���");
		System.out.println("[�̸� : ");
		selectName = sc1.nextLine(); // �̸�����

		System.out.println();
		System.out.println("::: ��ȭ�� �������ּ���.");
		System.out.println("��� [Movie]");

		// ��ȭ ��� ���
		for (int i = 0; i < movie.length; i++) {
			System.out.println(i + ". " + movie[i]);

		}

		System.out.println("[��ȭ : ");
		selectMovie = sc1.nextInt();
		System.out.println();

		for (int i = 0; i < movie.length; i++) {
			if (selectMovie == i) {
				System.out.println("[" + movie[i] + "] ���ÿϷ�Ǿ����ϴ�! \n");
				selectMovieName = movie[i];

			}
		}

		System.out.println();
		System.out.println("::: �¼��� �������ּ���");

		for (int i = 0; i < seat.length; i++) {
			for (int j = 0; j < seat[i].length; j++) {
				if (!seat[i][j].equals("-")) {
					System.out.print("��");
				} else {
					System.out.print("��");
				}
				if (j == 3 || j == 7) {
					System.out.print(" ");
				}
				
			}
			System.out.println();
		}
		System.out.println("��������������������������������������������������������������������");

		// �¼� ���̵� Ȯ���ϱ�(a-1, a-2, a-3, ... �ڸ�)
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

		System.out.println("[�¼� : ");
		String selectSeat1 = sc1.nextLine();
		String selectSeat = sc1.nextLine();
		System.out.println();
		
		/*
		 * ����ڰ� �Է��ϰ� ������ �̸�, ��ȭ, �¼� �����͸� �̿��Ͽ� ��ȭ ���Ÿ� ����
		 * */
		
		String[] arr = selectSeat.split("-");
		String seatId = arr[0];
		int seatNum = Integer.parseInt(arr[1]);
		
		//���� �̸�, ��ȭ, �¼���ȣ�� �̿��Ͽ� ��ȭ ���������� ����մϴ�.
		for (int i = 0; i<seat.length; i++) {
			if(seatId.equals(seatLine[i])) {
				seat[i][seatNum] = selectName + "-"
						+ selectMovieName + "-" +selectSeat;
			}
		}
		
		System.out.println("::: ������ �����մϴ�...");
		for (int i = 0; i<10; i++) {
			System.out.print("��"); 
			try {
				Thread.sleep(100);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(" 100%");
		System.out.println();
		
		money -= moviePrice[selectMovie];
		System.out.println("�� ������ �Ϸ�Ǿ����ϴ�.");
		System.out.println();
		System.out.println("��Ό�Ű� �Ϸ�Ǿ����ϴ�.");
		System.out.println("�� �̸� : " + selectName);
		System.out.println("�� ��ȭ : " + selectMovieName);
		System.out.println("�� �¼� : " + selectSeat);
		System.out.println("�� �ܾ� : " + money);
		
		
		
		
		
	}

}
