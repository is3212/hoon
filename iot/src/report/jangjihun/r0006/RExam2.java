package report.jangjihun.r0006;

public class RExam2 {
	protected int a=1;                            //protected는 기본적으로 디폴트 처럼 같은 패키지 안에서는 호출가능
	protected int b=2;                           //그리고 상속받았을때도 사용가능

	public int getA(){    //public 함수를 이용하여 호출
		return this.a;
		
	}
	public int getB(){
		return this.b;
		
	}
	public int setA(int a){
		return this.a=a;
	}
	public int setB(int b){
		return this.b=b;
}
}