package chapter11.sec02;

import java.util.List;

public class TempExample {

	public static void main(String[] args) {
		new TempExample().start(); // �ڱ� �ڽ��� ��ü ����� ���� // ��ü�� ������ ������
		
	}

	public void start() {
		TempDao tempDao = TempDao.getInstance(); // ���۵Ǵ� ��ġ
		// DaoŬ���� ��ü ���� -> Dao �� ������ �����ؼ� ����� ��ȯ���ִ� Ŭ����
	

		// tempNO�� ����Ǿ��ִ� ��� �����͸� �˻�
		// 
		String sql = "select * from TEMP ";
		List<TempVO> result = tempDao.selectList(sql);
		//������ ��� list �� �ڷḦ ��ȯ��
		//�Ȱ��� Ÿ������ �޾Ƽ� result ���� ����
	

		
//		for(TempVO tv : result) {
//			System.out.println(result);
//			System.out.println("------------------");
//			} // �̷��� �ϸ� ����� �� �ٸ� !
		
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
			System.out.println("------------------");
		}

	}

}
