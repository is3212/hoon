package report.jangjihun.r0007;

public class Exam8 {


public static void main(String[] args){
	Exam7 e7= new Exam7(4,5,6);            //private라는 변수를 함수로 불러오기 
	System.out.println(e7.getA());           //private는 같은 패키지라도 불러올수없기때문에 함수로 불러오는거
	System.out.println(e7.getB());
	System.out.println(e7.getC());
}
}
