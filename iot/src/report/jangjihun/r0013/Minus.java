package report.jangjihun.r0013;

public class Minus implements InterfaceExam{  //다중 가능

	public String getString() {

		return "Exam의 getString() 함수 호출 !!";
	}

	public void setString(String str) {
		System.out.println("Exam의 setString()함수 호출!!" + str);
		
		
	} 

	public int cal(int a, int b){
		return a-b;
	}

		
	}
    



