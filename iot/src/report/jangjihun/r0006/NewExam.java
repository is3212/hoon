package report.jangjihun.r0006;
//메모리
public class NewExam {
	public static void main(String[] args){
		String str1="a";
		String str2="a";
		System.out.println(str1==str2);
		str1=new String("b");
		str2=new String("b");
		System.out.println(str1==str2);  //클래스는 ==으로 비교할수없다
	}

}
