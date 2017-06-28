package report.jangjihun.r0007;

import java.util.Scanner;

public class Exam9 {
	//Exam9에 private int a, b, result를 선언해주세요
	//스캐너로 입력받는 a와 b를 함수로 만든다.
	//i가 a부터 b까지 도는 반복문을 작성한뒤
	//result의 i를 반복문만큼 더하는 함수를 작성해주세요/
	//result의 값을 출력하는 함수를 작성해서 Exam10에서 출력해주시기 바랍니다.
	private int a=0;
	private int b=0;
	private int result=0;
	Scanner scan;
	
	public Exam9(){                                     
		scan=new Scanner(System.in);    //생성자에 스캐너를 만들어놓으면 다시 안만들어도된다.		
	}
	
	public void inputA(){
		System.out.print("초기값을 입력하시오");
		String str=scan.nextLine();
		this.a=Integer.parseInt(str);
	}
	
	public void inputB(){
		System.out.print("맥스값을 입력하시오");
		String str2=scan.nextLine();
		this.b=Integer.parseInt(str2);
	}
	
	public void loop(){
	for(int i=this.a;i<=this.b;i++){
	result+=i;	
	}
	}
	
	public int getResult(){           //result가 private 이므로 함수를 만들어 result 출력할수있도록 만든다.
		return result;
	}
}