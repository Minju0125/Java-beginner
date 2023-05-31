package chapter11.sec02;

import java.util.List;

public class TempExample {

	public static void main(String[] args) {
		new TempExample().start(); // 자기 자신의 객체 만들고 나서 // 객체가 생성된 다음에
		
	}

	public void start() {
		TempDao tempDao = TempDao.getInstance(); // 시작되는 위치
		// Dao클래스 객체 만듦 -> Dao 는 쿼리를 실행해서 결과를 반환해주는 클래스
	

		// tempNO에 저장되어있는 모든 데이터를 검색
		// 
		String sql = "select * from TEMP ";
		List<TempVO> result = tempDao.selectList(sql);
		//실행한 결과 list 의 자료를 반환함
		//똑같은 타입으로 받아서 result 값에 저장
	

		
//		for(TempVO tv : result) {
//			System.out.println(result);
//			System.out.println("------------------");
//			} // 이렇게 하면 결과가 좀 다름 !
		
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
			System.out.println("------------------");
		}

	}

}
