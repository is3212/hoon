package report.jangjihun.r0004;

public class Exam3 {
	int a=0;
	
	public Exam3(){    //생성자는 리턴도 없고 void도 없다, 클래스명과 동일하게 대소문자까지 똑같이입력해야한다.
		                                 //생성자는 변수가 달라야하고, 순서도  달라야한다.
		                                //
	}
	public Exam3(int a){  //동일 함수 생성은 안되지만, 파라미터가 다르면 다른함수로 취급
		
	}
	public void printA(){
		
	}
	public void printA(int a){  //파라미터가 다르면 다른함수 = 오버로딩
		
	}
	
	public static void main(String[] args){
		Exam3 e=new Exam3();
		System.out.println(e.a);
	}

}
