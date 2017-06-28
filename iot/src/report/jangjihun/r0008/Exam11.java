package report.jangjihun.r0008;

public class Exam11 {
protected int a;                 //protected 를 써줌으로써, 상속받은 클래스로 접근 가능해진다.
protected int b;
	
	
	 public Exam11(int num1, int num2){
		this.a=num1;
		this.b=num2;
	}
	
	 protected int Plus(){
		return a+b;
	}
	
	 protected int Minus(){
		return a-b;
	}
	
	 protected int Multiple(){
		return a*b;
	}
	
	 protected int Division(){
		return a/b;
	}
	
	 protected void printResult(){
		System.out.println("+  결과값 = " + Plus());
		System.out.println("-  결과값 = " + Minus());
		System.out.println("*  결과값 = " + Multiple());
		System.out.println("/  결과값 = " + Division());
	}
	public static void main(String[] args){
		
	}

}
