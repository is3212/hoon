package report.jangjihun.r0005;

import java.util.Scanner;

public class Cal {
	// 인트타입의 2개의 파라미터 변수를 받는 생성자를 하나 만들어 주세요.
	// 클래스안에 인트타입의 변수 2개를 선언해주시고(멤버변수)-클래스 어디서나 쓸수있어서(멤버라서)
	// 클래스안에 있는 변수 2개에 생성자에서 받은 파라미터 변수의 값을 대입하여
	// printPlus()를 함수에서 2개의 변수를 더한 값을 출력해주세요.
	//클래스안에 스트링타입의 연산자를 저장하는 변수를 선언
	//생성자에서 연산자를 저장하는 로직을 만들고
	//ptintCal()이라는 함수를 만들어 해당함수를 호출하였을때 알맞은 연산이 되는 프로그램을 만들어주세요.
	int a;
	int b;
	int cal;
	String c=" ";
	Cal(int a){
		System.out.println(a + "인트형변수 파리미터를 한개를 가진 생성자를 호출하셨네요!");
		this.a=a;
	}
	Cal(int a, int b, String c) { // 생성자
		this.a = a;
		this.b = b;
		this.c= c;
		
	}
	
	public void printCal(){
		if(this.c.equals("+")){
			cal=this.a+this.b;
			System.out.println(this.c + "연산 결과값 " + this.a  + " + " + this.b + "= " + cal );
		}
		else if(this.c.equals("-")){
			cal=this.a-this.b;
			System.out.println(this.c + "연산 결과값 " + this.a  + " - " + this.b + "= " + cal );
		}
		else if(this.c.equals("*")){
			cal=this.a*this.b;
			System.out.println(this.c + "연산 결과값 " + this.a  + " * " + this.b + "= " + cal);
		}
		else if(this.c.equals("/")){
			cal=this.a/this.b;
			System.out.println(this.c + "연산 결과값 " + this.a  + " / " + this.b + "= " + cal);
		}
		else
			System.out.println("연산자 오류");
	}

	public void printPlus() {
		System.out.println("두수의 더한 값= " + (a + b));
	}

	public static void main(String[] args) {

		Cal e = new Cal(10, 2,"*"); // 생성자에 파라미터 대입
		e.printPlus();
		e.printCal();
	}
}
