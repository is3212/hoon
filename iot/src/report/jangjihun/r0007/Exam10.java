package report.jangjihun.r0007;

import java.util.Scanner;

public class Exam10 {
	public static void main(String[] args){
		
		Exam9 e9=new Exam9();
		e9.inputA();
		e9.inputB();
		e9.loop();
		System.out.println(e9.getResult());              //result로 써서 출력하면 오류난다.  private이기때문에
	}                                                                                           //그러므로 result를 return하는 함수를 만들어 함수를 호출한다.

}
