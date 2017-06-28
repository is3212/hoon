package report.jangjihun.r0004;

public class Exam {
	public void printPlustResult(int a, int b){
		System.out.println("더한 결과값 : " + (a+b));
	}

	public int getPlustResult(int a, int b){
		return a+b;
	}
	public static  void main(String[] args){
		Exam e=new Exam();
		e.printPlustResult(1,3);
		int result=e.getPlustResult(1,3);
		System.out.println("더한 결과값 : " + result);
	}
}
