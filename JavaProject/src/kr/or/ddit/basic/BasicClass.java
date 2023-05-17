package kr.or.ddit.basic;

public class BasicClass {
/*
 * 혼자 공부하는 자바
 * 
 * 앞으로 기초자바 수업은 JavaProject 인 JavaProject에서 진행하도록 합니다.
 * 혼자 공부하는 자바 커리큘럼 내에서 중요한 포인트 요소만 골라서 전체적으로 한번씩 보고 넘어가도록 합니다.
 * 
 * 1. 자바 시작하기
 * -JRE, JDK는 무엇인가?
 * 		JRE : 자바 실행 환경 (개발을 할 수는 없음 !)
 * 		JDK : 실행환경 + 도구 (개발을 할 수 있음) JAVA DEVELOPMENT KIT . JRE를 포함
 * -자바 환경변수 설정
 * 		내컴퓨터-시스템 속성-고급시스템설정- 환경변수 설정 JAVA_HOME 빈 폴더 전(jdk1.8.0_361)으로 설정
 * 		path 편집 -> 자바 홈 집어넣음
 * -이클립스 사용 버전 및 설정 방법
 * 		
 * -주석  
 * 1) 단일 주석 //
 * 2) /* 그룹주석 */
/* 3) doc 주석
 *  
 * -메인 
 * ma 치고 ctrl + 스페이스
 * 
 * 1) JRE와 JDK란 무엇인가?
 * 	JRE란?
 * 		-JRE(Java Runtime Environment)는 자바 실행 환경으로서,
 * 		  자바 프로그램을 개발하기 위한 컴파일러, 디버거가 따로 없어 실행하기 위한
 * 		  환경만 제공된다.
 * 
 *  JDK란?
 *  	-JDK(Java Development Kit)는 자바 개발 도구로서,
 *  	 자바 실행환경 (JRE)과 컴파일러, 디버거 등을 포함하고 있어 개발에 유용하다.
 *  	
 *  	** 우리가 사용하는 자바 버전은 JDK1.8 버전이다.
 *  	  현재 현업에서도 그렇고 평균적으로 JDK1.8 버전이 많이 상용화되어 있다.
 *  
 *  2) 자바 환경 변수 설정
 *  	JDK 응용프로그램으로 설치
 *  	- 응용프로그램으로 설치 시, C 드라이브에 자동 설치되어 JDK를 사용할 수 있다.
 *  
 *  	JDK 폴더로 설치
 *  	-JDK 폴더로 설치 시, 응용프로그램처럼 실행 후 설치되지 않고 내가 꺼내서 사용하고 싶을 땨
 *  	개별로 설정해서 서용할 수 있다.
 *  
 *  	환경변수 설정
 *  	-내 컴퓨터 > 고급 시스템 설정 > 환경변수 > 아래 시스템 변수에 두가지 셋팅 설정을 시정
 *  	JAVA_HOME 이라는 이름으로 D:\B.Util\Java\JDK1.8 과 같은 경로로 설정한다,
 *  	PATH 라는 이름을 찾아 JDK1.8 버전의 환경을 설정한다,(%JAVA_HOME%\bin)의
 *  	경로로 설정하고 순서를 맨 위로 올린다.
 *  	-cmd (명령 프롬프트)를 실행해 'java-version' 명령어를 통해 환경변수로
 *  	JDK가 정황하게 설치되었는지 확인한다.
 *  	자바 버전이 나타나지 않는다면 환경변수 설정을 다시 설정해야한다.
 *  
 *  3) 이클립스 사용버전 및 설정
 *  
 *  	이클립스 사용 버전
 *  	-Eclipse 2020-06 R 버전을 사용
 *  	-이유는 2020-06 R 버전 이후부터는 JDK 1.8을 지원하지 않음
 *  
 *  	이클립스 설정
 *  	-첫번째, 인코딩 설정을 진행한다.
 *  		> window > preferences 메뉴의 'enc' 검색후 , left 메뉴의 영역
 *  		모두를 'UTF-8'로 설정한다.
 *  	-두번째, font 설정을 진행한다.
 *  		> window > preferences 메뉴의 'font' 검색 후, Basic 영역의
 *  		text font를 원하는 폰트로 설정한다.
 *  		> 이곳에서 설정한 font 설정값이 정형ㅇ화 되어 꼭 이걸로 해야한다는 건 없으니
 *  		본인이 원하는 폰트로 선택하여 진행한다.
 *  		> 제일 좋은 font 설정은 내가 작성한 코드가 명확하게 잘 나타나고,
 *  		공백이 잘 드러날 수 있는 폰트면 더욱 좋다!
 *  	-세번째, > window > preferences 메뉴로 들어가 left menu들 중, 'java'
 *  		메뉴의 JDK 설정을 진행한다.
 *  		> installed JREs메뉴로 들어가 기본 셋팅인 JRE를 우리가 사용할 JDK로
 *  		변경한다.
 *  
 *  4) 자바 주석 종류
 *  	주석에 대한 설명은 혼자 공부하는 자바 P38쪽을 참고하길 바란다.
 *  	여기만 봐도 충분! 주석은 단지 내가 작성하는 소스를 가리거나 소스상에 설명을 달기 위해서
 *  	사용하는 Comment 와 같은 역할을 담당하는 친구이기 때문에 장황한 설명이 필요하지 않다.
 *  
 *  5) 메인(실행 진입점)
 *  	우리가 개발하는 시스템이 시작하는 진입점이 필요하다.
 *  	그래야 시작이 되는 해당 진입점부터 시스템이 동작하기 떄문에 그것에서부터 뿌리가
 *  	퍼져나간다!
 *  	우리가 자바 프로젝트로 만드는 시스템이 빌드되고 컴파일 되어 시작되면 main()
 *  	메소드가 실행되어 시스템이 시작된다!
 *  
 * 		 ** 메인은 시스템을 시작하기 위한 시작점라고 생각하면 된다!
 *  
 *  
 *  2. 변수와 타입
 *  -변수 선언 및 초기화
 *  -변수 명명 규칙
 *  -기본 타입
 *  -타입 변환
 *  -변수와 시스템 입출력
 *  
 *  ┌━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┐
 *  │** 사용 패키지: kr.or.ddit.variable │
 *  │** 사용 패키지: VariableClass       │
 *  ┖━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * 
 *  * 
 * 
 */
	public static void main(String[] args) {
		
	}
}