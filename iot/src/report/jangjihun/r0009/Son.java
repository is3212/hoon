package report.jangjihun.r0009;

public class Son extends Father{
	public String toString(){
		return "아부지 아들입니다.";
	}
	public static void main(String[] args){
		Father f=new Father();
		System.out.println(f);
		Son s=new Son();
		//Father s= new Son();               아빠가 상위클래스이기때문에 오류안남 그리고 아부지 아들입니다가 출력된다. new Son으로 했기때문에
		System.out.println(s);
	}

}
