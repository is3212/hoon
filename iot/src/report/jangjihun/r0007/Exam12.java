package report.jangjihun.r0007;

import report.jangjihun.r0008.Exam11;


public class Exam12 extends Exam11{ //Exam11을 상위 클래스로 상속
Exam12(int a, int b){                   //밑에 메인에서 생성자 값을 넣어주기위해
	super(a,b);
	this.a=a;
	this.b=b;
}

	public static void main(String[] args){
		Exam12 e12=new Exam12(4,2);  //Exam11에서 빈 생성자를 만들었으므로, 파라미티가 없어도된다.
		e12.Plus();
		e12.Minus();
		e12.Multiple();
		e12.Division();
		e12.printResult();
		
	}

}
