package chapter06.exam01;

import java.lang.Math;
// 원주율은 Math.PI

//문제 1. 원(Circle), 사각형(Rectangle), 삼각형(Triangle) 클래스는 도형 클래스 (Shape)을 상속 받아 생성된다.
//(1) 도형클래스는 면적을 구하는 메서드(calArea)만 존재한다.  - System.out.println(”면적을 계산”)
//(2) 원(Circle)
//         - 속성 : 반지름
//         - 메서드 : 면적을 구하는 메서드 (calArea)
//                         둘레를 구하는 메서드 (calCircum)
//(3) 사각형(Rectangle) 
//         - 속성 : 가로(width), 세로(height)
//         - 메서드 : 면적을 구하는 메서드 (calArea)
//(4) 삼각형(Triangle)
//         - 속성 : 밑변(width), 높이(height)
//         - 메서드 : 면적을 구하는 메서드 (calArea)

// 부모클래스
// 공통적인 속성 또는 메소드만
public class Shape {
	
	
	public void calcArea() {
		System.out.println("도형의 면적을 계산");
	}


	
	
	

}
