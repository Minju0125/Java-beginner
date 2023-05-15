package chap05.homework02;

public class Homework {

	public static void main(String[] args) {
		HomeworkEx hw = new HomeworkEx();
//		hw.printScore();
		hw.SumAvgRank();

	}

}

class HomeworkEx {
	String[] names = { "홍길동", "이순신", "정몽주", "강감찬", "이성계" };
	int[][] score = { { 70, 80, 60, 0, 0 }, { 80, 90, 90, 0, 0 }, { 90, 80, 90, 0, 0 }, { 75, 80, 80, 0, 0 },
			{ 60, 70, 60, 0, 0 } };

	public void printScore(int[][] score) {
//		String [] names = null;
//		names = new String [] {"홍길동", "이순신", "정몽주", "강감찬", "이성계"};

		for (int i = 0; i < names.length; i++) {
			System.out.print(names[i]);
			for (int j = 0; j < score[i].length; j++) {
				System.out.printf("%6d", score[i][j]);
			}
			System.out.println();

		}

	}

	void SumAvgRank() {

		int[][] score = { { 70, 80, 60, 0, 0, 1 }, { 80, 90, 90, 0, 0, 1 }, { 90, 80, 90, 0, 0, 1 },
				{ 75, 80, 80, 0, 0, 1 }, { 60, 70, 60, 0, 0, 1 } };
		for (int i = 0; i < names.length; i++) {
			for (int j = 0; j < 3; j++) {
				score[i][3] = score[i][3] + score[i][j];
			}
			score[i][4] = score[i][3] / 3;
		}

		for (int i = 0; i < names.length; i++) {
			for (int j = 0; j < names.length; j++) {
				if (score[i][3] < score[j][3]) {
					score[i][5]++;

				}
			}

		}

		printScore(score);
	}
}