package report.jangjihun.r0006;

import report.jangjihun.r0006.Father;
import report.jangjihun.r0006.Son;

public class Son extends Father{
	int a;
	
	public static void main(String[] args){
		Son s = new Son();
		s.a =3;
		System.out.println(s.getAdress());   //son에서 father의 private 선언된 함수 출력
		System.out.println(s.getAge());  //son에서 father의 private 선언된 함수 출력
		System.out.println(s.getName());  //son에서 father의 private 선언된 함수 출력
		s.setName("박경훈"); //박경훈 이름을 함수에 대입
		System.out.println(s.getName());// private name 변수에 대입된 박경훈 출력
		
	}
}

