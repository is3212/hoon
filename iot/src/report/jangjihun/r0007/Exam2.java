package report.jangjihun.r0007;

import report.jangjihun.r0006.RExam4;

public class Exam2{
	public static void main(String[] args){
		Exam1 e1= new Exam1();
		System.out.println(e1.a);
		System.out.println(e1.b);
		
		Exam1 e2= new Exam1();
		e1.a=4;
		System.out.println(e2.a);
		System.out.println(e2.b);
		RExam4 e4=new RExam4();
		System.out.println(e4.a);                // RExam4는 디폴트 int a이므로  다른 패키지인 Exam2에서 e4.a 오류
		System.out.println(e4.b);               //
	}

}
