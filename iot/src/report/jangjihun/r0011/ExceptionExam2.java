package report.jangjihun.r0011;

import java.util.Scanner;

public class ExceptionExam2 {
	//10개의 방을 가지고 있는 int형 배열변수 arrNum을
	//ExceptionExam2의 멤버변수로 선언해주세요
	//for문을 돌며 Scanner 클래스의 nextLine()함수를 사용하여 아무런 값이나 입력해주세요
	//단 for문을 돌며  문자값이 입력됐을때, 에러메세지를 나오게 해주세요.
	int[] arrNum= new int[10];
	public static void main(String[] args){
		ExceptionExam2 ee=new ExceptionExam2();
		Scanner scan=new Scanner(System.in);
			
		try{
			for(int i=0;i<ee.arrNum.length;i++){
				System.out.println("값을 입력하시오");
			ee.arrNum[i]=Integer.parseInt(scan.nextLine());
		
			}
	
			for(int i=0;i<ee.arrNum.length;i++){
				System.out.println( i + "결과값 = " + ee.arrNum[i]);
			}
		}
			catch(Exception e){
			System.out.println("아니 숫자를 입력해야지??");
			
		
		}
	}
		
}

