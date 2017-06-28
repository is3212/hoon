package report.jangjihun.r0011;

import java.util.Scanner;

public class ExceptionExam {
	 // ExceptionExam의 멤버변수로 int num1, num2를 선언해주세요
	// 멤버변수 num1과 num2값을 계산하여 int값을 리턴하는
	// plus(), minus(), multiple(), division() 함수를 4개 선언하여 이름에 맞게 연산하여 리턴해주세요
	// Scanner 클래스의 nextLine()함수를 사용하여 num1 값과 num2값을 대입해주세요
	// 숫자값을 입력하지 않았을때는 Exception에서 "숫자를 입력해야지!!!"라는 문자열이 나와야합니다.
	// 정상적으로 숫자 값을 입력했다면
	// 위에 선언한 4개의 함수를 호출하여 값을 받아 출력하는 예제를 작성해주시기 바랍니다.
    int num1=0;
	int num2=0;
	final int NUM_EXAM;         //final(상수)로 선언하면은 절대로 안변함, 상수값은 대문자로 쓰자 알아보기쉽게
	                                                      //final 상수는 무조건 값이 선언되어야함
	                                                     //final에 초기값을 선언 안해줬으면
	
	ExceptionExam(){
		NUM_EXAM=1;             //생성자에서 값을 선언해주면 된다.
	}
	int Plus() {
		return num1 + num2;
	}

	int Minus() {
		return num1 - num2;
	}

	int Multiple() {
		return num1 * num2;
	}

	int Division() {
		return num1 / num2;
	}

	public static void main(String[] args) {
		ExceptionExam ee = new ExceptionExam();
        //try~catch, finally 문
		try {                                                            //try           예외의 발생이 예상되는 로직을 돌려서
			Scanner scan = new Scanner(System.in);
			System.out.println("num1값을 입력하시오");
			String str = scan.nextLine();
		   ee.num1 = Integer.parseInt(str);

			System.out.println("num2값을 입력하시오");
			String str2 = scan.nextLine();
			ee.num2 = Integer.parseInt(str2);
			
			System.out.println("더하기 결과값 = " + ee.Plus());
			System.out.println("빼기 결과값 = " + ee.Minus());
			System.out.println("곱하기 결과값 = " + ee.Multiple());
			System.out.println("나누기 결과값 = " + ee.Division());

		} catch (Exception e) {                //예외가 발생했을때 실행되는 로직
			System.out.println("숫자를 입력해야지!!!");

		}finally{
			System.out.println("난 무조건 실행됨!!!!!");        //finally는 오류가 나든 안나든 상관없이 무조건 출력된다.
		}

	}

}
